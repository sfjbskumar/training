package com.shantanu.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
public class MyCalculator {
    public String addString(String a,String b){
        return a.concat(b);
    }
}