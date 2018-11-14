package com.in28minutes.springboot.firstspringbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService service;

    @RequestMapping("/welcome")
    public String welcome() {
        return service.retriveWelcomeMessage();
    }
}

@Component
class WelcomeService {
    public String retriveWelcomeMessage() {
        return "Good Morning updated XXX";
    }
}
