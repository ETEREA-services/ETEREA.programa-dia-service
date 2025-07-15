package eterea.programa.dia.service.service.facade;

import eterea.programa.dia.service.client.web.OrderNoteClient;
import eterea.programa.dia.service.domain.dto.extern.OrderNoteDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderNoteServiceTest {

    @Mock
    private OrderNoteClient orderNoteClient;

    @InjectMocks
    private OrderNoteService orderNoteService;

    @Test
    void findAllCompletedByLastTwoDays_ShouldReturnListOfOrderNoteDto_WhenOrdersExist() {
        // Given
        OrderNoteDto orderNote = new OrderNoteDto();
        orderNote.setOrderNumberId(123L);
        when(orderNoteClient.findAllCompletedByLastTwoDays()).thenReturn(List.of(orderNote));

        // When
        List<OrderNoteDto> result = orderNoteService.findAllCompletedByLastTwoDays();

        // Then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(123L, result.get(0).getOrderNumberId());
    }

    @Test
    void findAllCompletedByLastTwoDays_ShouldReturnEmptyList_WhenNoOrdersExist() {
        // Given
        when(orderNoteClient.findAllCompletedByLastTwoDays()).thenReturn(Collections.emptyList());

        // When
        List<OrderNoteDto> result = orderNoteService.findAllCompletedByLastTwoDays();

        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void findByOrderNumberId_ShouldReturnOrderNoteDto_WhenOrderExists() {
        // Given
        Long orderNumberId = 456L;
        OrderNoteDto orderNote = new OrderNoteDto();
        orderNote.setOrderNumberId(orderNumberId);
        when(orderNoteClient.findByOrderNumberId(orderNumberId)).thenReturn(orderNote);

        // When
        OrderNoteDto result = orderNoteService.findByOrderNumberId(orderNumberId);

        // Then
        assertNotNull(result);
        assertEquals(orderNumberId, result.getOrderNumberId());
    }

    @Test
    void findByOrderNumberId_ShouldReturnNull_WhenOrderDoesNotExist() {
        // Given
        Long orderNumberId = 789L;
        when(orderNoteClient.findByOrderNumberId(orderNumberId)).thenReturn(null);

        // When
        OrderNoteDto result = orderNoteService.findByOrderNumberId(orderNumberId);

        // Then
        assertNull(result);
    }
}
