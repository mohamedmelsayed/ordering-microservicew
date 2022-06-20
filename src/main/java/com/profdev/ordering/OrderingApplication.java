package com.profdev.ordering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class OrderingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderingApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/order").allowedOrigins("http://localhost:1222");
				registry.addMapping("/api/v1/options/status").allowedOrigins("http://localhost:1222");
				registry.addMapping("/api/v1/options/size").allowedOrigins("http://localhost:1222");
				registry.addMapping("/api/v1/options/coffee").allowedOrigins("http://localhost:1222");
				registry.addMapping("/api/v1/options/milk").allowedOrigins("http://localhost:1222");

			}
		};
	}

}
