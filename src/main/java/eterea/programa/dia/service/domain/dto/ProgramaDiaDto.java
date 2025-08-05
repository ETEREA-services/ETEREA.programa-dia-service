package eterea.programa.dia.service.domain.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramaDiaDto {

    private List<VoucherDto> vouchers;
    private List<ReservaOrigenDto> reservaOrigens;
    private List<ClienteMovimientoDto> clienteMovimientos;
    private String errorMessage;

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

}
