package com.example.springstartherepart2.ch7_10;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * After Thymeleaf adding is not working because html pages
 * are searched in templates directory (not static).
 */
@Controller
public class StartController {

    @RequestMapping("start")
    public String start() {
        return "start.html";
    }
}
