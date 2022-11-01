package com.example.shantan.s2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
    @GetMapping("me")
    public String greeting()
    {
        return "Shantanu";
    }
}
