package com.example.springstartherepart2.ch7_10.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Unit test for com.example.springstartherepart2.ch7_10.controller.LoginController.
 */
@ExtendWith(MockitoExtension.class)
class LoginControllerUnitTests {
    /*Assumptions - identify and control dependencies - Arrange*/
    @Mock
    private Model model;

    @Mock
    private LoginProcessor loginProcessor;

    @InjectMocks
    private LoginController loginController;

    @Test
    void loginPostLoginSucceedsTest() {
        /*Assumptions - identify and control dependencies - Arrange*/
        given(loginProcessor.login()).willReturn(true);

        /*Call - Execution - Act - can pass any username and pass because of loginProcessor.login() returns true*/
        String result = loginController.loginPost("username", "password", model);

        /*Validations - Assert*/
        assertEquals("redirect:/main", result);
        verify(model).addAttribute("message", "You are now logged in");
    }

    @Test
    void loginPostLoginFailsTest() {
        /*Assumptions - identify and control dependencies*/
        given(loginProcessor.login()).willReturn(false);

        /*Call - Execution - can pass any username and pass because of loginProcessor.login() returns true*/
        String result = loginController.loginPost("username", "password", model);

        /*Validations - assertions*/
        assertEquals("login.html", result);
        verify(model).addAttribute("message", "Login failed!");
    }
}