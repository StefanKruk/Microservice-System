package de.stefankruk.microservice;

import de.stefankruk.microservice.common.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class WebAccountService {

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    @Value("${service.url}")
    private String serviceUrl;

    public List<Account> getAll(){
        Account[] forEntity = restTemplate.getForObject(serviceUrl + "/accounts", Account[].class);
        return Arrays.asList(forEntity);
    }
}
