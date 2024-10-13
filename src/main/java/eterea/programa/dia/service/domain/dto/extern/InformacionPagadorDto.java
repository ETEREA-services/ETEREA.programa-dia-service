package eterea.programa.dia.service.domain.dto.extern;

import lombok.Data;

@Data
public class InformacionPagadorDto {

    private Long orderNumberId;
    private String eMail = "";
    private String nombre = "";
    private String numeroDocumento = "";
    private String telefono;
    private String tipoDocumento = "";

}
