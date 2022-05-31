package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.service.LoggedUserManagementService;
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

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout, Model model) {
        /*if logout parameter present we erase username from LoggedUserManagementService bean*/
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        String username = loggedUserManagementService.getUsername();

        if (username == null) {
            return "redirect:/";
        }

        model.addAttribute("username", username);
        return "main.html";
    }
}
