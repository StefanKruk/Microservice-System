package de.stefankruk.microservice.frontend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Value("${my.name:World}")
    private String name;

    @Value("${index}")
    private String index;

    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("name", name);
        return index;
    }
}