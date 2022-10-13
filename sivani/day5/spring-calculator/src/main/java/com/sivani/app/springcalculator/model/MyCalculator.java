package com.sivani.app.springcalculator.model;

import org.springframework.stereotype.*;
@Component
public class MyCalculator {
    public String addString(String a, String b){
        return a.concat(b);
    }
}