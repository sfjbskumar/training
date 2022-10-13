package com.bhavesh.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("hi")
    public String greeting(){
        return "hello";
    }

//    @GetMapping("add")
//    public float addition(@RequestParam(name = "a", required = true) float a, @RequestParam(name = "b", required = true) float b) {
//        return a+b;
//    }



}
