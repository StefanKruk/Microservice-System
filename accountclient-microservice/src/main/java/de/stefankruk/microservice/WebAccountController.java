package de.stefankruk.microservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RefreshScope
@RestController()
public class WebAccountController {

    @Value("${my.message}")
    private String home;

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.url}")
    private String serviceUrl;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home(){
        return home;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/feignexample")
    public Collection<Account> feignExample(){
        Resources<Account> all = accountClient.getall();
        return all.getContent();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/templateexample")
    public Collection<Account> templateExample(){
        ParameterizedTypeReference<Resources<Account>> ref = new ParameterizedTypeReference<Resources<Account>>(){};
        ResponseEntity<Resources<Account>> exchange = restTemplate.exchange(serviceUrl + "/accounts", HttpMethod.GET, null, ref);
        return exchange.getBody().getContent();
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(method = RequestMethod.GET, value = "/hystrixexample")
    public List<String> hystrixExample(){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("Hystrix Example");
        ParameterizedTypeReference<Resources<Account>> ref = new ParameterizedTypeReference<Resources<Account>>(){};
        ResponseEntity<Resources<Account>> exchange = restTemplate.exchange(serviceUrl + "/acc", HttpMethod.GET, null, ref);
        return objects;
    }

    public List<String> fallback(){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("Fallback Method says Hello");
        return objects;
    }

}
