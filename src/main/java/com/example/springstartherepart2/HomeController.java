package com.example.springstartherepart2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * There are 4 cases for data sending through HTTP request:
 * 1) an HTTP request parameter;
 * 2) a path variable;
 * 3) an HTTP request header;
 * 4) the HTTP request body.
 */
@Controller
public class HomeController {

    /**
     * Controller for home.html page. URI is
     * e.g. http://localhost:8080/home?color=orange&name=Jane
     * <p>
     * Can be used with optional values.
     * For GET query parameters are sent in URI.
     *
     * @param color first parameter of query
     * @param name  second parameter of query
     * @param page  object sent from Controller to View Resolver
     * @return page name
     */
    @RequestMapping("home")
    public String home(@RequestParam(required = false) String color,
                       @RequestParam(required = false) String name,
                       Model page) {
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "home.html";
    }

    /**
     * Controller for home.html page. URI is
     * http://localhost:8080/home/blue
     *
     * Path variable should not be used with optional values.
     * Avoid if more than 2 variables.
     *
     * @param color variable of path
     * @param page  object sent from Controller to View Resolver
     * @return page name
     */
    @RequestMapping("home/{color}")
    public String home(@PathVariable String color, Model page) {
        page.addAttribute("username", "Katty");
        page.addAttribute("color", color);
        return "home.html";
    }
}
