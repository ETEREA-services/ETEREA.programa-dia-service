package eterea.programa.dia.service.domain.dto;

import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class ProgramaDiaDtoTest {
    @Test
    void builderAndGetters() {
        ProgramaDiaDto dto = ProgramaDiaDto.builder()
            .vouchers(Collections.emptyList())
            .reservaOrigens(Collections.emptyList())
            .clienteMovimientos(Collections.emptyList())
            .errorMessage("error")
            .build();
        assertNotNull(dto);
        assertEquals("error", dto.getErrorMessage());
        assertNotNull(dto.getVouchers());
        assertNotNull(dto.getReservaOrigens());
        assertNotNull(dto.getClienteMovimientos());
    }
}
