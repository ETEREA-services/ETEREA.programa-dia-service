package eterea.programa.dia.service.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProgramaDiaDto {

    private List<VoucherDto> vouchers;
    private List<ReservaOrigenDto> reservaOrigens;
    private List<ClienteMovimientoDto> clienteMovimientos;
    private String errorMessage;

}
