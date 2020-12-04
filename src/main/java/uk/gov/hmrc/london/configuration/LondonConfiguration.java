package uk.gov.hmrc.london.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import uk.gov.hmrc.london.handler.RestTemplateResponseErrorHandler;

@Configuration
public class LondonConfiguration {

    @Autowired
    @Bean()
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return new RestTemplateBuilder().errorHandler(new RestTemplateResponseErrorHandler()).build();
    }
}
