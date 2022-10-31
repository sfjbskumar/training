package com.triveni.app.firstspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @GetMapping("/add")
    public float additional(@RequestParam(name="a",required = true) float a,@RequestParam(name = "b" , required = true) float b){
        return a+b;
    }
    @GetMapping("/sub")
    public int subtraction(@RequestParam(name = "a",required = true) int a,@RequestParam(name ="b",required =true) int b){
        if(a>b){
            return a-b;
        }
        else{
            return 0;
        }
    }

}
