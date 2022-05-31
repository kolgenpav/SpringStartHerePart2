package com.example.springstartherepart2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * We don’t need to change the scope for LoginController
 * as long as it doesn’t store any detail in its attributes.
 */
@Controller
public class LoginController {
    /*In the book dependency does not injected, but code does not work*/
    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    /**
     * Takes parameters from LoginProcessor instance.
     */
    @PostMapping("/")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {

        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();
        if (loggedIn) {
            model.addAttribute("message", "You are now logged in");
        } else {
            model.addAttribute("message", "Login failed!");
        }
        return "login.html";
    }
}
