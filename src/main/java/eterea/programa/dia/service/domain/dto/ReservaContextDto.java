package eterea.programa.dia.service.domain.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaContextDto {

    private Long reservaContextId;
    private Long reservaId;
    private Long voucherId;
    private Long clienteMovimientoId;
    private Long orderNumberId;
    @Builder.Default
    private Byte facturadoFuera = 0;
    @Builder.Default
    private Byte facturaPendiente = 0;
    @Builder.Default
    private Integer facturaTries = 0;
    @Builder.Default
    private Byte envioPendiente = 0;
    @Builder.Default
    private Integer envioTries = 0;
    @Builder.Default
    private BigDecimal diferenciaWeb = BigDecimal.ZERO;
    @Builder.Default
    private Byte facturaArca = 0;

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
