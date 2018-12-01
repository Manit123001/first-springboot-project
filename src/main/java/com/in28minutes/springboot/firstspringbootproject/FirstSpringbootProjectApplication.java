package com.in28minutes.springboot.firstspringbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class FirstSpringbootProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringbootProjectApplication.class, args);
    }

    @Profile("prod")
    @Bean
    public String dummy() {
        return "something";
    }
}
