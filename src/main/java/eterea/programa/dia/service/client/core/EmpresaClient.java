package eterea.programa.dia.service.client.core;

import eterea.programa.dia.service.domain.dto.EmpresaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("core-service/api/core/empresa")
public interface EmpresaClient {

    @GetMapping("/top")
    EmpresaDto findTop();

}
