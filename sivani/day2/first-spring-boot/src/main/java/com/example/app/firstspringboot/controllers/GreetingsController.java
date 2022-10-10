package com.example.app.firstspringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    @GetMapping("/hi")
    public String sayHi(){
        return "Hi World";
    }
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
    @GetMapping("/thanks")
    public String sayThanks(){
        return "Thank you";
    }


}
