package com.techlab.c10.springboot_demo_c10.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "👋 ¡Hola desde Spring Boot! 🚀";
    }
}