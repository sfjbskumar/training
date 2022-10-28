package com.uddesh.app.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public float add(@RequestParam(name = "a") float a , @RequestParam(name = "b") float b){
        return a+b;
    }

    @GetMapping("/sub")
    public float sub(@RequestParam(name = "a") float a , @RequestParam(name = "b") float b){
        return a-b;
    }

    @GetMapping("/mul")
    public float mul(@RequestParam(name = "a") float a , @RequestParam(name = "b") float b){
        return a*b;
    }

    @GetMapping("/div")
    public float div(@RequestParam(name = "a") float a , @RequestParam(name = "b") float b){
        return a/b;
    }
}
