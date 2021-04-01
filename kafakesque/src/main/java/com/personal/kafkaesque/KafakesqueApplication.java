package com.personal.kafkaesque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class KafakesqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafakesqueApplication.class, args);
	}
	
	@Configuration
	public class CorsConfig implements WebFluxConfigurer {
		
	     public void addCorsMappings(CorsRegistry corsRegistry) {
	          corsRegistry.addMapping("/**")
	          .allowedOrigins("*");
	     }
	}

}
