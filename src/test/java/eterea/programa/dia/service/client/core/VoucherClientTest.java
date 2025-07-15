package eterea.programa.dia.service.client.core;

import eterea.programa.dia.service.domain.dto.VoucherDto;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.openfeign.FeignClient;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class VoucherClientTest {
    @Test
    void hasFeignClientAnnotation() {
        assertNotNull(VoucherClient.class.getAnnotation(FeignClient.class));
    }

    @Test
    void allMethodsArePresent() throws Exception {
        Method m1 = VoucherClient.class.getMethod("findAllByUserToday", String.class);
        Method m2 = VoucherClient.class.getMethod("findAllByFechaServicio", java.time.OffsetDateTime.class, Boolean.class, Boolean.class);
        Method m3 = VoucherClient.class.getMethod("findByNumeroVoucher", String.class);
        Method m4 = VoucherClient.class.getMethod("findByVoucherId", Long.class);
        assertNotNull(m1);
        assertNotNull(m2);
        assertNotNull(m3);
        assertNotNull(m4);
    }
}
