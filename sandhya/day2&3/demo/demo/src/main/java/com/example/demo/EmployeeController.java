package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmployeeController {
 @GetMapping("sandhya")
 public String greeting(){
     return "sandhya";
 }

}
