package eterea.programa.dia.service.client.core;

import eterea.programa.dia.service.domain.dto.ClienteMovimientoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "core-service", contextId = "clienteMovimientoClient", path = "/api/core/clienteMovimiento")
public interface ClienteMovimientoClient {

    @GetMapping("/findAllByReservaIds/{reservaIds}")
    List<ClienteMovimientoDto> findAllByReservaIds(@PathVariable List<Long> reservaIds);

    @GetMapping("/reserva/{reservaId}")
    List<ClienteMovimientoDto> findAllByReservaId(@PathVariable Long reservaId);

}
