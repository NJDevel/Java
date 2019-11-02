package com.trilogyed.stwittereurekaserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StwitterEurekaServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StwitterEurekaServiceRegistryApplication.class, args);
	}

}
