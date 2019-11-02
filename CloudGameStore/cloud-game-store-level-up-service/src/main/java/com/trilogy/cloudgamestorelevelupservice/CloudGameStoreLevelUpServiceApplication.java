package com.trilogy.cloudgamestorelevelupservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
//@EnableCaching
public class CloudGameStoreLevelUpServiceApplication {

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		JavaTimeModule module = new JavaTimeModule();
		ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
		objectMapper.registerModule(module);
		return new Jackson2JsonMessageConverter(objectMapper);
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudGameStoreLevelUpServiceApplication.class, args);
	}

}
