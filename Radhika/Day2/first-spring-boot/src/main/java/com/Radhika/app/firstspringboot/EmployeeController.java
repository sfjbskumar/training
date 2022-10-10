package com.Radhika.app.firstspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("hi")
    public String greeting() {
        return "Hello";
    }

}
