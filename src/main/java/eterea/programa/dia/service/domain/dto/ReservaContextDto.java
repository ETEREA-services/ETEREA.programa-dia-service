package eterea.programa.dia.service.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReservaContextDto {

    private Long reservaContextId;
    private Long reservaId;
    private Long voucherId;
    private Long clienteMovimientoId;
    private Long orderNumberId;
    private Byte facturadoFuera = 0;
    private Byte facturaPendiente = 0;
    private Integer facturaTries = 0;
    private Byte envioPendiente = 0;
    private Integer envioTries = 0;
    private BigDecimal diferenciaWeb = BigDecimal.ZERO;

}
