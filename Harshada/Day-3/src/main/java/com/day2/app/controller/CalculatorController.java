package com.day2.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CalculatorController {
    @GetMapping("add")
    public float addition(@RequestParam(name = "a", required = true) float a, @RequestParam(name = "b", required = true) float b) {
        return a+b ;
    }
    @GetMapping("sub")
    public float subtraction(@RequestParam(name = "a", required = true) float a, @RequestParam(name = "b", required = true) float b) {
        return a-b ;
    }
    @GetMapping("mul")
    public float multiplication(@RequestParam(name = "a", required = true) float a, @RequestParam(name = "b", required = true) float b) {
        return a*b ;
    }
    @GetMapping("div")
    public float division(@RequestParam(name = "a", required = true) float a, @RequestParam(name = "b", required = true) float b) {
        return a/b ;
    }

}
