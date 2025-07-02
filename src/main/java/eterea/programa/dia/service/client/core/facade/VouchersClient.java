package eterea.programa.dia.service.client.core.facade;

import eterea.programa.dia.service.domain.dto.ProgramaDiaDto;
import eterea.programa.dia.service.domain.dto.TrackDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("core-service/api/core/vouchers")
public interface VouchersClient {

    @PostMapping("/import/web/one/{orderNumberId}")
    ProgramaDiaDto importOneFromWeb(@PathVariable Long orderNumberId, @RequestBody TrackDto track);

}
