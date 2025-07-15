package eterea.programa.dia.service.client.core.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "core-service", contextId = "makeFacturaProgramaDiaClient", path = "/api/core/make-factura-programa-dia")
public interface MakeFacturaProgramaDiaClient {

    @GetMapping("/factura/{reservaId}/{comprobanteId}")
    Boolean facturaReserva(@PathVariable Long reservaId, @PathVariable Integer comprobanteId);

}
