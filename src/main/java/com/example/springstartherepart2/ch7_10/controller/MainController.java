package com.example.springstartherepart2.ch7_10.controller;

import com.example.springstartherepart2.ch7_10.service.LoggedUserManagementService;
import com.example.springstartherepart2.ch7_10.service.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller that check username from session bean (LoggedUserManagementService) and returns main.html page for logged user
 * and redirects to root page with login form for unlogged user.
 */
@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public MainController(LoggedUserManagementService loggedUserManagementService,
                          LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout, Model model) {
        /*if logout parameter present we erase username from LoggedUserManagementService bean*/
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        String username = loggedUserManagementService.getUsername();
        int count = loginCountService.getCount();

        if (username == null) {
            return "redirect:/";
        }

        model.addAttribute("username", username);
        model.addAttribute("loginCount", count);
        return "main.html";
    }
}
