package com.kumar.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("hii")
    private String greeting(){
        System.out.println("Hii sent");
        return "hii";
    }
}
