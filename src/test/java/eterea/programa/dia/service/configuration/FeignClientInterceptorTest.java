package eterea.programa.dia.service.configuration;

import eterea.programa.dia.service.service.util.RequestUuidHolder;
import feign.RequestTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeignClientInterceptorTest {
    @Test
    void apply_addsHeaderIfUuidPresent() {
        FeignClientInterceptor interceptor = new FeignClientInterceptor();
        RequestTemplate template = new RequestTemplate();
        RequestUuidHolder.set("uuid-test");
        interceptor.apply(template);
        assertTrue(template.headers().containsKey("X-Request-ID"));
        assertEquals("uuid-test", template.headers().get("X-Request-ID").iterator().next());
        RequestUuidHolder.clear();
    }

    @Test
    void apply_doesNotAddHeaderIfUuidNull() {
        FeignClientInterceptor interceptor = new FeignClientInterceptor();
        RequestTemplate template = new RequestTemplate();
        RequestUuidHolder.clear();
        interceptor.apply(template);
        assertFalse(template.headers().containsKey("X-Request-ID"));
    }
}
