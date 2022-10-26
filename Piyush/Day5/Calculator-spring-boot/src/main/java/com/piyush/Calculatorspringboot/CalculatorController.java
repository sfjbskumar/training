package com.piyush.Calculatorspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
//http://localhost:8080/div?a=3&b=5
    @GetMapping("/add")
    public float addition(@RequestParam(name = "a", required = true) float a, @RequestParam(name = "b",required = true) float b){
        return a+b;
    }

    @GetMapping("/sub")
    public float subtraction(@RequestParam(name = "a", required = true) int a, @RequestParam(name = "b",required = true) int b){
        return a-b;
    }

    @GetMapping("/mul")
    public float multiplication(@RequestParam(name = "a", required = true) int a, @RequestParam(name = "b",required = true) int b){
        return a*b;
    }

    @GetMapping("/div")
    public float division(@RequestParam(name = "a", required = true) int a, @RequestParam(name = "b",required = true) int b){
        return a/b;
    }

    MyCalculator myCalculator= new MyCalculator();

    @GetMapping("/addstring")
    public String addString(@RequestParam(name = "a", required = true) String a, @RequestParam(name = "b", required = true) String b) {
        return myCalculator.addString(a,b);
    }

    @GetMapping("/mod")
    public float mod(@RequestParam(name = "a", required = true) int a, @RequestParam(name = "b", required = true) int b) {
        return myCalculator.mod(a, b);
    }
}
