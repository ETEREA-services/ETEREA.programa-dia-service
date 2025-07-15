package eterea.programa.dia.service.client.web;

import eterea.programa.dia.service.domain.dto.extern.OrderNoteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "import-service", contextId = "orderNoteClient", path = "/orderNote")
public interface OrderNoteClient {

    @GetMapping("/{orderNumberId}")
    OrderNoteDto findByOrderNumberId(@PathVariable Long orderNumberId);

    @GetMapping("/lastTwoDays")
    List<OrderNoteDto> findAllCompletedByLastTwoDays();

}
