package com.example.springstartherepart2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoggedUserManagementService {
    /*Because the LoggedUserManagementService bean is session-scoped, the username
     value will now be accessible throughout the entire HTTP session.
     You can use this value to know if someone is logged in, and who.
     You don’t have to worry about the case where multiple users are logged in;
     the application framework makes sure to link each HTTP request
     to the correct session.*/
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
