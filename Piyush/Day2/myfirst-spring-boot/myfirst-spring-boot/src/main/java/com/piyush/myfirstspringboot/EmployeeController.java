package com.piyush.myfirstspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("Hi")
    public  String greeting(){
        return "Hello";
    }
}
