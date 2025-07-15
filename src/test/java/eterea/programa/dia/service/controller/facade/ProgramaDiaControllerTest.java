package eterea.programa.dia.service.controller.facade;

import eterea.programa.dia.service.domain.dto.ProgramaDiaDto;
import eterea.programa.dia.service.exception.ProgramaDiaException;
import eterea.programa.dia.service.service.facade.ProgramaDiaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ProgramaDiaController.class)
class ProgramaDiaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProgramaDiaService service;

    @Test
    void findAllByFecha_returnsOk() throws Exception {
        ProgramaDiaDto dto = ProgramaDiaDto.builder().build();
        Mockito.when(service.findAllByFechaServicio(any(OffsetDateTime.class), eq(true), eq(false))).thenReturn(dto);

        mockMvc.perform(get("/api/programa-dia/programaDia/fechaServicio/2025-07-15T10:00:00Z/true/false")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void findByVoucherId_returnsOk() throws Exception {
        ProgramaDiaDto dto = ProgramaDiaDto.builder().build();
        Mockito.when(service.findByVoucherId(1L)).thenReturn(dto);

        mockMvc.perform(get("/api/programa-dia/programaDia/voucher/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void findByVoucherId_returnsBadRequest_onException() throws Exception {
        Mockito.when(service.findByVoucherId(2L)).thenThrow(new ProgramaDiaException(2L));

        mockMvc.perform(get("/api/programa-dia/programaDia/voucher/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void importOneFromWeb_returnsOk() throws Exception {
        mockMvc.perform(get("/api/programa-dia/programaDia/importOneFromWeb/123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void importManyCompletedFromWeb_returnsOk() throws Exception {
        mockMvc.perform(get("/api/programa-dia/programaDia/importManyCompletedFromWeb")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
