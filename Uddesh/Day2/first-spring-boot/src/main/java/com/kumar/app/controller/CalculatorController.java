package com.kumar.app.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    private float add(@RequestParam(name="a") float a , @RequestParam(name="b") float b){
        return a+b;
    }

    @GetMapping("/sub")
    private float sub(@RequestParam(name="a") float a , @RequestParam(name="b") float b){
        return a-b;
    }

    @GetMapping("/mul")
    private float mul(@RequestParam(name="a") float a , @RequestParam(name="b") float b){
        return a*b;
    }

    @GetMapping("/div")
    private float div(@RequestParam(name="a") float a , @RequestParam(name="b") float b){
        return a/b;
    }
}
