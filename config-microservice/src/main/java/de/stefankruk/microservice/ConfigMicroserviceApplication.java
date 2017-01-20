package de.stefankruk.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringCloudApplication
@EnableConfigServer
public class ConfigMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigMicroserviceApplication.class, args);
	}
}
