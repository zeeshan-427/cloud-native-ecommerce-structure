package com.ecommerce.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        System.out.println("CI/CD TEST - Version 3");
        SpringApplication.run(AuthApplication.class, args);
    }
}