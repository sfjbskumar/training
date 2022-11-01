package com.example.firstspringbootapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeCotroller {
    @GetMapping("hi")
    public String greeting(){
        return "hello";
    }
}
