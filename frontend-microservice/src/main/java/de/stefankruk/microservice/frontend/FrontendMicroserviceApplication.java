package de.stefankruk.microservice.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringCloudApplication
@EnableRedisHttpSession
public class FrontendMicroserviceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FrontendMicroserviceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FrontendMicroserviceApplication.class, args);
    }

    @Bean
    public HomeController homeController() {
        return new HomeController();
    }
}