package com.sagar.app.firstspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("hi")
    public String welcomeClass(){
      return "Hi";
   }
    @GetMapping(value = "/hi/1")
    public String welcomeClass2(){
        return "Hi Sagar";
    }
    @GetMapping(value = "/hi/2")
    public String welcomeClass3(){
        return "Welcome to class";
    }
}
