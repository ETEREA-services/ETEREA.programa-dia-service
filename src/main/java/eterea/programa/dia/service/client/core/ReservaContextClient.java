package eterea.programa.dia.service.client.core;

import eterea.programa.dia.service.domain.dto.ReservaContextDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("core-service/api/core/reservacontext")
public interface ReservaContextClient {

    @GetMapping("/facturacion/pendiente")
    List<ReservaContextDto> findAllByFacturacionPendiente();

}
