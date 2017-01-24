package de.stefankruk.microservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController()
public class WebAccountController {

    @Value("${my.message}")
    private String home;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home(){
        return home;
    }

}
