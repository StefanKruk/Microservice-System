package de.stefankruk.microservice.frontend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RefreshScope
@Controller
public class HomeController {

    @Value("${my.name:World}")
    private String name;

    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}