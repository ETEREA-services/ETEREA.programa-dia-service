package eterea.programa.dia.service.configuration;

import eterea.programa.dia.service.service.util.RequestUuidHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private static final String REQUEST_ID_HEADER = "X-Request-ID";

    @Override
    public void apply(RequestTemplate template) {
        String uuid = RequestUuidHolder.get();
        if (uuid != null) {
            template.header(REQUEST_ID_HEADER, uuid);
        }
    }

}
