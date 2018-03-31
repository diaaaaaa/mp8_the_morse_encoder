package at.refugeescode.mp8_the_morse_encoder.encoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

