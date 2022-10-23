package com.uddesh.app.controller;


import org.springframework.stereotype.Component;

@Component
public class MyCalculator {

    public String addString(String a , String b){
        return a+b;
    }

    public float mod(float a , float b){
        return a%b;
    }
}
