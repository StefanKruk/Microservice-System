package de.stefankruk.microservice.common.account;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Account")
public class Account {

    private String name;

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
