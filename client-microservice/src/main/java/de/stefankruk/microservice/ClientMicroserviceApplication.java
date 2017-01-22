package de.stefankruk.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class ClientMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientMicroserviceApplication.class, args);
	}
}
