package eterea.programa.dia.service.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservaOrigenDto {

    private Integer reservaOrigenId;
    private String nombre;

}
