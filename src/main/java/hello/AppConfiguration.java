package hello;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {
	
	
	@Bean(name = "restTemplate")
	public RestTemplate restTemplate(final RestTemplateBuilder restTemplateBuilder) {
		// Do any additional configuration here
		return restTemplateBuilder.build();
	}

}
