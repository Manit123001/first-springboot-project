package com.in28minutes.springboot.firstspringbootproject.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WelcomeControllerTest {
    @Autowired
    WelcomeController welcomeController;

    @Test
    public void testWelcome() {
//        String name = welcomeController.welcome();
//        boolean check = name.equals("Good Morning updated XXX");
//        assertTrue(check);
    }
}