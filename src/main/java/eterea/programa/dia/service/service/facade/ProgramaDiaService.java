package eterea.programa.dia.service.service.facade;

import eterea.programa.dia.service.client.core.*;
import eterea.programa.dia.service.client.core.facade.MakeFacturaProgramaDiaClient;
import eterea.programa.dia.service.client.core.facade.VouchersClient;
import eterea.programa.dia.service.domain.dto.*;
import eterea.programa.dia.service.domain.dto.extern.OrderNoteDto;
import eterea.programa.dia.service.exception.ProgramaDiaException;
import eterea.programa.dia.service.service.util.RequestUuidHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProgramaDiaService {

    private final VoucherClient voucherClient;
    private final ClienteMovimientoClient clienteMovimientoClient;
    private final ReservaOrigenClient reservaOrigenClient;
    private final EmpresaClient empresaClient;
    private final ReservaContextClient reservaContextClient;
    private final VouchersClient vouchersClient;
    private final MakeFacturaProgramaDiaClient makeFacturaProgramaDiaClient;

    private final OrderNoteService orderNoteService;
    private final TrackClient trackClient;

    public ProgramaDiaDto findAllByFechaServicio(OffsetDateTime fechaServicio, Boolean soloConfirmados,
                                                 Boolean porNombrePax) {
        List<VoucherDto> vouchers = voucherClient.findAllByFechaServicio(fechaServicio, soloConfirmados, porNombrePax);
        List<Long> reservaIds = vouchers.stream().map(VoucherDto::getReservaId)
                .filter(reservaId -> reservaId > 0).collect(Collectors.toList());
        List<ClienteMovimientoDto> clienteMovimientos = clienteMovimientoClient.findAllByReservaIds(reservaIds);
        return ProgramaDiaDto.builder()
                .vouchers(vouchers)
                .reservaOrigens(reservaOrigenClient.findAll())
                .clienteMovimientos(clienteMovimientos)
                .build();
    }

    public ProgramaDiaDto findByVoucherId(Long voucherId) {
        VoucherDto voucher = null;
        try {
            voucher = voucherClient.findByVoucherId(voucherId);
        } catch (Exception e) {
            throw new ProgramaDiaException(voucherId);
        }
        List<VoucherDto> vouchers = new ArrayList<>();
        vouchers.add(voucher);
        ReservaOrigenDto reservaOrigen = reservaOrigenClient.findByReservaOrigenId(voucher.getReservaOrigenId());
        List<ReservaOrigenDto> reservaOrigens = new ArrayList<>();
        reservaOrigens.add(reservaOrigen);
        List<ClienteMovimientoDto> clienteMovimientos = clienteMovimientoClient
                .findAllByReservaId(voucher.getReservaId());
        return ProgramaDiaDto.builder()
                .vouchers(vouchers)
                .reservaOrigens(reservaOrigens)
                .clienteMovimientos(clienteMovimientos)
                .build();
    }

    public void importOneFromWeb(Long orderNumberId, OrderNoteDto orderNote) {
        if (orderNote == null) {
            orderNote = orderNoteService.findByOrderNumberId(orderNumberId);
        }
        log.debug("importing order_note={}", orderNote.getOrderNumberId());
        if (orderNote.getPayment() == null) {
            log.debug("order_note={} no tiene pago", orderNote.getOrderNumberId());
            return;
        }
        var track = trackClient.startTracking("import-one-from-web-" + orderNumberId);
        log.debug("Track -> {}", track.jsonify());
        final String trackUuid = track.getUuid();
        log.debug("calling core.importOneFromWeb -> {}", orderNote.getOrderNumberId());
        try {
            RequestUuidHolder.set(trackUuid);
            ProgramaDiaDto programaDiaDto = vouchersClient.importOneFromWeb(orderNote.getOrderNumberId());
            log.debug("programaDiaDto -> {}", programaDiaDto.jsonify());
            if (programaDiaDto.getVouchers() != null) {
                VoucherDto voucher = programaDiaDto.getVouchers().getFirst();
                log.debug("calling core.facturaReserva -> {}", voucher.getReservaId());
                boolean isFacturado = makeFacturaProgramaDiaClient.facturaReserva(voucher.getReservaId(), 853);
                if (!isFacturado) {
                    log.debug("error facturando reserva={}", voucher.getReservaId());
                }
            }
        } finally {
            RequestUuidHolder.clear();
        }
    }

    public void importManyCompletedFromWeb() {
        // Si el negocio no es agencia no hago nada
        if (empresaClient.findTop().getNegocioId() != 54) {
            return;
        }
        // Importa las reservas web e intenta facturarlas
        for (OrderNoteDto orderNote : orderNoteService.findAllCompletedByLastTwoDays()) {
            importOneFromWeb(orderNote.getOrderNumberId(), orderNote);
        }
        // Intenta facturar las reservas que quedaron sin facturar
        for (ReservaContextDto reservaContext : reservaContextClient.findAllByFacturacionPendiente()) {
            log.debug("ReservaContext -> {}", reservaContext.jsonify());
            log.debug("Creating track");
            var track = trackClient.startTracking("factura-from-web-pendiente-" + reservaContext.getOrderNumberId());
            log.debug("Track -> {}", track.jsonify());
            try {
                RequestUuidHolder.set(track.getUuid());
                log.debug("calling core.facturaReserva -> {}", reservaContext.getReservaId());
                boolean isFacturado = makeFacturaProgramaDiaClient.facturaReserva(reservaContext.getReservaId(), 853);
                if (!isFacturado) {
                    log.debug("error facturando reserva -> {}", reservaContext.getReservaId());
                }
            } finally {
                RequestUuidHolder.clear();
            }
        }
    }

}
