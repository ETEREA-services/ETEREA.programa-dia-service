package eterea.programa.dia.service.domain.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrackDto {

    private String uuid;
    private String descripcion;

    @Builder.Default
    private Status status = Status.IN_PROGRESS;

    public String jsonify() {
        try {
            return JsonMapper
                    .builder()
                    .findAndAddModules()
                    .build()
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "jsonify error -> " + e.getMessage();
        }
    }

    public enum Status {
        IN_PROGRESS,
        COMPLETED,
        FAILED
    }

}
