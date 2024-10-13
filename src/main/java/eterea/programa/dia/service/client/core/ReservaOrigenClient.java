package eterea.programa.dia.service.client.core;

import eterea.programa.dia.service.domain.dto.ReservaOrigenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("core-service/api/core/reservaorigen")
public interface ReservaOrigenClient {

    @GetMapping("/")
    List<ReservaOrigenDto> findAll();

    @GetMapping("/{reservaOrigenId}")
    ReservaOrigenDto findByReservaOrigenId(@PathVariable Integer reservaOrigenId);


}
