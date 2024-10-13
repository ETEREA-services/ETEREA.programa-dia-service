package eterea.programa.dia.service.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ComprobanteDto {

    private Integer comprobanteId;
    private String descripcion = "";
    private Integer negocioId;
    private Integer modulo;
    private Byte stock = 0;
    private Byte rendicion = 0;
    private Byte ordenPago = 0;
    private Byte aplicaPendiente = 0;
    private Byte cuentaCorriente = 0;
    private Byte debita = 0;
    private Byte iva = 0;
    private Byte ganancias = 0;
    private Byte aplicable = 0;
    private Byte libroIva = 0;
    private String letraComprobante;
    private Byte recibo = 0;
    private Byte contado = 0;
    private Byte transferencia = 0;
    private Byte imprime = 0;
    private Integer comprobanteIdAnulacion;
    private Integer centroStockIdEntrega;
    private Integer centroStockIdRecibe;
    private Integer diasVigencia;
    private Byte concepto = 0;
    private Byte personal = 0;
    private Byte comanda = 0;
    private Integer puntoVenta = 0;
    private Byte codigoMozo = 0;
    private Byte transferir = 0;
    private Long numeroCuenta;
    private Integer nivel = 0;
    private Byte fiscalizadora = 0;
    private Byte invisible = 0;
    private Integer comprobanteAfipId;
    private Byte facturaElectronica = 0;
    private Byte asociado = 0;

    private CuentaDto cuenta;
}
