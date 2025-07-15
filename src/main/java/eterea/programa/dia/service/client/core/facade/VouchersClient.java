package eterea.programa.dia.service.client.core.facade;

import eterea.programa.dia.service.domain.dto.ProgramaDiaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "core-service", contextId = "vouchersClient", path = "/api/core/vouchers")
public interface VouchersClient {

    @GetMapping("/import/web/one/{orderNumberId}")
    ProgramaDiaDto importOneFromWeb(@PathVariable Long orderNumberId);

}
