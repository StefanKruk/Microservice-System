package de.stefankruk.microservice.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringCloudApplication
@EnableResourceServer
public class FrontendMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontendMicroserviceApplication.class, args);
    }

}