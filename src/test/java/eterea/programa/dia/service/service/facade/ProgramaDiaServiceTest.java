package eterea.programa.dia.service.service.facade;

import eterea.programa.dia.service.client.core.ClienteMovimientoClient;
import eterea.programa.dia.service.client.core.ReservaOrigenClient;
import eterea.programa.dia.service.client.core.VoucherClient;
import eterea.programa.dia.service.domain.dto.ClienteMovimientoDto;
import eterea.programa.dia.service.domain.dto.ProgramaDiaDto;
import eterea.programa.dia.service.domain.dto.ReservaOrigenDto;
import eterea.programa.dia.service.domain.dto.VoucherDto;
import eterea.programa.dia.service.exception.ProgramaDiaException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProgramaDiaServiceTest {

    @Mock
    private VoucherClient voucherClient;

    @Mock
    private ClienteMovimientoClient clienteMovimientoClient;

    @Mock
    private ReservaOrigenClient reservaOrigenClient;

    @InjectMocks
    private ProgramaDiaService programaDiaService;

    @Test
    void findAllByFechaServicio_ShouldReturnDtoWithVouchers_WhenVouchersExist() {
        // Given
        OffsetDateTime fecha = OffsetDateTime.now();
        VoucherDto voucher = new VoucherDto();
        voucher.setReservaId(1L);
        List<VoucherDto> mockVouchers = List.of(voucher);

        when(voucherClient.findAllByFechaServicio(any(OffsetDateTime.class), anyBoolean(), anyBoolean()))
                .thenReturn(mockVouchers);
        when(clienteMovimientoClient.findAllByReservaIds(anyList())).thenReturn(Collections.emptyList());
        when(reservaOrigenClient.findAll()).thenReturn(Collections.emptyList());

        // When
        ProgramaDiaDto result = programaDiaService.findAllByFechaServicio(fecha, true, true);

        // Then
        assertNotNull(result);
        assertFalse(result.getVouchers().isEmpty());
        assertEquals(1, result.getVouchers().size());
        assertEquals(1L, result.getVouchers().get(0).getReservaId());
    }

    @Test
    void findAllByFechaServicio_ShouldReturnDtoWithEmptyVouchers_WhenNoVouchersExist() {
        // Given
        OffsetDateTime fecha = OffsetDateTime.now();
        when(voucherClient.findAllByFechaServicio(any(OffsetDateTime.class), anyBoolean(), anyBoolean()))
                .thenReturn(Collections.emptyList());
        when(clienteMovimientoClient.findAllByReservaIds(anyList())).thenReturn(Collections.emptyList());
        when(reservaOrigenClient.findAll()).thenReturn(Collections.emptyList());

        // When
        ProgramaDiaDto result = programaDiaService.findAllByFechaServicio(fecha, true, true);

        // Then
        assertNotNull(result);
        assertTrue(result.getVouchers().isEmpty());
    }

    @Test
    void findByVoucherId_ShouldReturnDto_WhenVoucherExists() {
        // Given
        Long voucherId = 123L;
        VoucherDto mockVoucher = new VoucherDto();
        mockVoucher.setVoucherId(voucherId);
        mockVoucher.setReservaOrigenId(1);
        mockVoucher.setReservaId(456L);

        when(voucherClient.findByVoucherId(voucherId)).thenReturn(mockVoucher);
        when(reservaOrigenClient.findByReservaOrigenId(anyInt())).thenReturn(new ReservaOrigenDto());
        when(clienteMovimientoClient.findAllByReservaId(anyLong())).thenReturn(Collections.singletonList(new ClienteMovimientoDto()));

        // When
        ProgramaDiaDto result = programaDiaService.findByVoucherId(voucherId);

        // Then
        assertNotNull(result);
        assertEquals(1, result.getVouchers().size());
        assertEquals(voucherId, result.getVouchers().get(0).getVoucherId());
        assertNotNull(result.getReservaOrigens());
        assertNotNull(result.getClienteMovimientos());
    }

    @Test
    void findByVoucherId_ShouldThrowProgramaDiaException_WhenClientFails() {
        // Given
        Long voucherId = 123L;
        when(voucherClient.findByVoucherId(voucherId)).thenThrow(new RuntimeException("Client failed"));

        // When & Then
        assertThrows(ProgramaDiaException.class, () -> {
            programaDiaService.findByVoucherId(voucherId);
        });
    }
}