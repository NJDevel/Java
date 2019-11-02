package com.trilogy.cloudgamestoreinvoiceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudGameStoreInvoiceServiceApplication {



	public static void main(String[] args) {
		SpringApplication.run(CloudGameStoreInvoiceServiceApplication.class, args);
	}

}
