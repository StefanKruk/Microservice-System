package de.stefankruk.microservice.frontend;

import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }
}