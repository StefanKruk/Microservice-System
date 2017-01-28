package de.stefankruk.microservice.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@SpringCloudApplication
@EnableOAuth2Client
public class FrontendMicroserviceApplication extends WebSecurityConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(FrontendMicroserviceApplication.class, args);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .logout().and()
                .authorizeRequests()
                .antMatchers("/index.html", "/home.html", "/", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        // @formatter:on
    }
}