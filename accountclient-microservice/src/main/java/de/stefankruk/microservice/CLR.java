package de.stefankruk.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Component
public class CLR implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.url}")
    private String serviceUrl;


    @Override
    public void run(String... args) throws Exception {
        Account forObject = restTemplate.getForObject(serviceUrl + "/accounts/2", Account.class);
        System.err.println(forObject.getName());
    }
}

@Service
@FeignClient("account-microservice")
interface AccountClient {

    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    Resources<Account> getall();

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{name}")
    Account getAccount(@PathVariable("name") int name);
}

@Component
class FeignExample implements CommandLineRunner {

    @Autowired
    private AccountClient accountClient;

    @Override
    public void run(String... strings) throws Exception {
        Account account = accountClient.getAccount(1);
        System.err.println("Account: "+ account.getName());

        Resources<Account> getall = accountClient.getall();
        getall.getContent().forEach(n -> System.out.println(n.getName()));

    }
}
