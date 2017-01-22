package de.stefankruk.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class AccountCLR implements CommandLineRunner {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountCLR(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Stefan", "Tim", "Josh", "Johannes").forEach(n -> accountRepository.save(new Account(n)));
    }
}
