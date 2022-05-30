package com.example.springstartherepart2.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Login data processor. We need to change the scope to @RequestScope
 * for creating a new instance of LoginProcessor
 * for every HTTP requests that process details of each user.
 * So more users with different credentials might attempt to log in simultaneously.
 */
@Component
@RequestScope   //process data of unique request. Spring creates a new instance
// of the class for every HTTP request
public class LoginProcessor {
    /*The bean stores the credentials as attributes*/
    private String username;
    private String password;

    /*In the book code is different, but does not work*/
    public boolean login(String username, String password) {
        /*Get attributes from the request*/
        this.username = username;
        this.password = password;
        System.out.println(this); //for different requests will be different instance hashcode
        if ("natalie".equals(username) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
