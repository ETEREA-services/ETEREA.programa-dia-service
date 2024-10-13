package eterea.programa.dia.service.domain.dto;

import lombok.Data;

@Data
public class ProveedorDto {

    private Long proveedorId;
    private String razonSocial = "";
    private Integer negocioId;
    private String cuit = "";
    private String domicilio = "";
    private String telefono = "";
    private String fax = "";
    private String email = "";
    private Integer posicion = 0;
    private String celular = "";
    private String numeroInscripcionIngresosBrutos = "";
    private Integer ingresosBrutosContribuyenteId;
    private Integer proveedorCategoriaId;
    private Integer inressosBrutosCategoriaId;
    private Integer reparticionId;
    private Byte transporte = 0;

}
