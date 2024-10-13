package eterea.programa.dia.service.configuration;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableDiscoveryClient
@EnableScheduling
@EnableFeignClients(basePackages = {"eterea.programa.dia.service.client"})
public class ProgramaDiaConfiguration {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("admin", "admin");
    }

}
