package eterea.programa.dia.service.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalTime;
import java.time.OffsetDateTime;

@Data
public class VoucherDto {

    private Long voucherId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaToma;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaServicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaVencimiento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime horaVencimiento = LocalTime.of(0, 0, 0);

    private String nombrePax;
    private Integer paxs;
    private String subeEn = "";
    private String productos;
    private Byte tieneVoucher;
    private Long clienteId;
    private String observaciones;
    private Byte confirmado;
    private Byte pagaCacheuta;
    private Integer hotelId;
    private String contacto = "";
    private Integer paxsReales;
    private Integer proveedorId;
    private String planilla = "";
    private Long reservaId;
    private String numeroVoucher;
    private String usuario;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaRecepcion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaEmision;

    private String numero;
    private Integer cantidadPax;
    private String nombre;
    private Byte conTraslado;
    private Integer paxsNoShow;
    private Integer reservaOrigenId;
    private Byte fechaAbierta = 0;
    private Byte ventaInternet = 0;

    private UsuarioDto user;
    private ClienteDto cliente;
    private HotelDto hotel;
    private ProveedorDto proveedor;
    private ReservaDto reserva;

}
