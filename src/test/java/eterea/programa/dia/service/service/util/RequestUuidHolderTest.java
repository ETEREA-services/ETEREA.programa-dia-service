package eterea.programa.dia.service.service.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RequestUuidHolderTest {
    @Test
    void testSetAndGet() {
        String uuid = "test-uuid";
        RequestUuidHolder.set(uuid);
        assertEquals(uuid, RequestUuidHolder.get());
        RequestUuidHolder.clear();
        assertNull(RequestUuidHolder.get());
    }
}
