package eterea.programa.dia.service.domain.dto;

import lombok.Data;

@Data
public class MonedaDto {

    private Integer monedaId;
    private String nombre = "";
    private String simbolo = "";
    private Integer valorId;

}
