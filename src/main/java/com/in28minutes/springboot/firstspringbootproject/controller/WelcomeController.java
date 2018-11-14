package com.in28minutes.springboot.firstspringbootproject.controller;

import com.in28minutes.springboot.firstspringbootproject.services.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService service;

    @GetMapping("/welcome")
    public String welcome() {
        System.out.println("Hello Sexy");
        return service.retrieveWelcomeMessage();
    }
}

