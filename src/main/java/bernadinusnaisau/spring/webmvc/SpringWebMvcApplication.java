package bernadinusnaisau.spring.webmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;



@SpringBootApplication
@ServletComponentScan
public class SpringWebMvcApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder
				.requestFactory(() -> {
					var factory = new SimpleClientHttpRequestFactory();
					factory.setConnectTimeout(10_000);
					factory.setReadTimeout(10_000);
					return factory;
				})
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringWebMvcApplication.class, args);
	}

}
