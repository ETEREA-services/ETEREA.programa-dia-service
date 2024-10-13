package eterea.programa.dia.service.service.facade;

import eterea.programa.dia.service.client.web.OrderNoteClient;
import eterea.programa.dia.service.domain.dto.extern.OrderNoteDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class OrderNoteService {

    private final OrderNoteClient orderNoteClient;

    public OrderNoteService(OrderNoteClient orderNoteClient) {
        this.orderNoteClient = orderNoteClient;
    }

    public OrderNoteDto findByOrderNumberId(@PathVariable Long orderNumberId) {
        return orderNoteClient.findByOrderNumberId(orderNumberId);
    }

    public List<OrderNoteDto> findAllCompletedByLastTwoDays() {
        return orderNoteClient.findAllCompletedByLastTwoDays();
    }

}
