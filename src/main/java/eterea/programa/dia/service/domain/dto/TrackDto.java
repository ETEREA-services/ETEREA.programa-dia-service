package eterea.programa.dia.service.domain.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrackDto {

    private String uuid;
    private String descripcion;
    private Status status = Status.IN_PROGRESS;

    public enum Status {
        IN_PROGRESS,
        COMPLETED,
        FAILED
    }

}
