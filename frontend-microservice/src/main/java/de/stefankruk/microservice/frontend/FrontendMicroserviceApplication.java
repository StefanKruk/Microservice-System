package de.stefankruk.microservice.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class FrontendMicroserviceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FrontendMicroserviceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FrontendMicroserviceApplication.class, args);
    }
}
