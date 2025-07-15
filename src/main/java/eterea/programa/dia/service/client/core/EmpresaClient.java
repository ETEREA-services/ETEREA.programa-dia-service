package eterea.programa.dia.service.client.core;

import eterea.programa.dia.service.domain.dto.EmpresaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "core-service", contextId = "empresaClient", path = "/api/core/empresa")
public interface EmpresaClient {

    @GetMapping("/top")
    EmpresaDto findTop();

}
