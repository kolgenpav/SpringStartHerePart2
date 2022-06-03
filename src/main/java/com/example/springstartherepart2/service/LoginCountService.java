package com.example.springstartherepart2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * Counts all login attempts registered and unregistered users.
 */
@Service
@ApplicationScope
public class LoginCountService {
    private int count;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
