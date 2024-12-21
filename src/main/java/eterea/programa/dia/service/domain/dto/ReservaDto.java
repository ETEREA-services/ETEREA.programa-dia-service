package eterea.programa.dia.service.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Data
public class ReservaDto {

    private Long reservaId;
    private Integer negocioId;
    private Long clienteId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaToma;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaInServicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaOutServicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaVencimiento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime horaVencimiento = LocalTime.of(0, 0, 0);

    private Byte avisoMail = 0;
    private Byte pendiente = 0;
    private Byte confirmada = 0;
    private Byte facturada = 0;
    private Byte anulada = 0;
    private Byte eliminada = 0;
    private Byte verificada = 0;
    private String nombrePax = "";
    private Integer cantidadPaxs = 0;
    private String observaciones = "";
    private Long voucherId;
    private Byte pagaComision = 0;
    private String observacionesComision = "";
    private Byte comisionPagada = 0;
    private Byte pagaCacheuta = 0;
    private Byte facturadoFuera = 0;
    private String reservaArticulos = "";
    private String usuario = "";
    private String contacto = "";
    private Integer reservaOrigenId;
    private Byte facturarExtranjero = 0;
    private Byte fechaAbierta = 0;
    private BigDecimal diferenciaWeb = BigDecimal.ZERO;

    private ClienteDto cliente;

}
