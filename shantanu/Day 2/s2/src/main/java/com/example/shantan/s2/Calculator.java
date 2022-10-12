package com.example.shantan.s2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator
{
    @GetMapping("/add")
    public float add(@RequestParam(name = "a", required = true) float a, @RequestParam(name = "b", required = true) float b)
    {
        return a+b;
    }
    @GetMapping("/sub")
    public float sub(@RequestParam(name = "a", required = true) float a, @RequestParam(name = "b", required = true) float b)
    {
        return a-b;
    }
    @GetMapping("/mul")
    public float mul(@RequestParam(name = "a", required = true) float a, @RequestParam(name = "b", required = true) float b)
    {
        return a*b;
    }
    @GetMapping("/div")
    public float div(@RequestParam(name = "a", required = true) float a, @RequestParam(name = "b", required = true) float b)
    {
        return a/b;
    }
}
