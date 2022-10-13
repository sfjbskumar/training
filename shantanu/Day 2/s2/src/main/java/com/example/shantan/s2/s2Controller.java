package com.example.shantan.s2;

import org.springframework.web.bind.annotation.GetMapping;

public class s2Controller
{
    @GetMapping("i")
    public String greeting()
    {
        return "Shantanu";
    }
}
