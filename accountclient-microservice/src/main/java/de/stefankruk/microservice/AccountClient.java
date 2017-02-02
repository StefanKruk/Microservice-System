package de.stefankruk.microservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@FeignClient("account-microservice")
public interface AccountClient {

    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    Resources<Account> getall();
}
