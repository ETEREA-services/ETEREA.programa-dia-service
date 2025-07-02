package eterea.programa.dia.service.client.core.facade;

import eterea.programa.dia.service.domain.dto.TrackDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("core-service/api/core/make-factura-programa-dia")
public interface MakeFacturaProgramaDiaClient {

    @PostMapping("/factura/{reservaId}/{comprobanteId}")
    Boolean facturaReserva(@PathVariable Long reservaId, @PathVariable Integer comprobanteId, @RequestBody TrackDto track);

}
