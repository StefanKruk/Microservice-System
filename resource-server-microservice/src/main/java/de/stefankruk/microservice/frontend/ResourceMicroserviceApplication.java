package de.stefankruk.microservice.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class ResourceMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceMicroserviceApplication.class, args);
    }
}