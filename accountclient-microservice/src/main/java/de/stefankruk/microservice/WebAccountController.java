package de.stefankruk.microservice;

import de.stefankruk.microservice.common.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class WebAccountController {

    @Autowired
    private WebAccountService webAccountService;

    @RequestMapping("/acocunts")
    public List<Account> getAll(){
        System.err.println("ALERT");
        return webAccountService.getAll();
    }
}
