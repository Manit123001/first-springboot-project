package com.in28minutes.springboot.firstspringbootproject.services;

import org.springframework.stereotype.Component;

@Component
public class WelcomeService {
    public String retrieveWelcomeMessage() {
        return "Good Morning updated XXX";
    }
}
