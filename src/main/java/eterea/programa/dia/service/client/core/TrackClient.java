package eterea.programa.dia.service.client.core;

import eterea.programa.dia.service.domain.dto.TrackDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("core-service/api/core/track")
public interface TrackClient {

    @GetMapping("/start/{descripcion}")
    TrackDto startTracking(@PathVariable String descripcion);

}
