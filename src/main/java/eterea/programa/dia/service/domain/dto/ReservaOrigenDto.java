package eterea.programa.dia.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaOrigenDto {

    private Integer reservaOrigenId;
    private String nombre;

}
