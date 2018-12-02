package com.in28minutes.springboot.firstspringbootproject.controller;

import com.in28minutes.springboot.firstspringbootproject.configuration.BaseConfiguration;
import com.in28minutes.springboot.firstspringbootproject.services.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService service;

    @Autowired
    private BaseConfiguration configuration;

    @GetMapping("/welcome")
    public String welcome() {
        return service.retrieveWelcomeMessage();
    }

    @RequestMapping("/dynamic-configuration")
    public Map dynamicConfiguration() {
        // Not the best practice to use a map to store differnt types!
        Map map = new HashMap();
        map.put("message", configuration.getMessage());
        map.put("number", configuration.getNumber());
        map.put("key", configuration.isValue());
        return map;
    }

}

