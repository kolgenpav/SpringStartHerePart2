package com.example.springstartherepart2.ch7_10.controller;

import com.example.springstartherepart2.ch7_10.service.LoggedUserManagementService;
import com.example.springstartherepart2.ch7_10.service.LoginCountService;
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

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    /*The bean stores the credentials as attributes*/
    private String username;
    private String password;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService,
                          LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    public boolean login() {
        loginCountService.increment();
        /*Get attributes from the request*/
        String username = this.getUsername();
        String password = this.getPassword();
//        System.out.println(this); //for different requests will be different instance hashcode
        boolean loginResult = false;
        if ("natalie".equals(username) && "password".equals(password)) {
            loginResult = true;
            /*Store username in the session bean*/
            loggedUserManagementService.setUsername(username);
        } else {
            loginResult = false;
        }
        return loginResult;
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
