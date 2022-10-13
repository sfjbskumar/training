package com.sivani.app.springcalculator.Controllers;

import com.sivani.app.springcalculator.model.MyCalculator;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CalculatorController{

    //private final MyCalculator myCalculator;
    @Autowired
    MyCalculator myCalculator;

    @GetMapping("/addString")
    public String addString(@RequestParam(name="a", required=true) String a,
                            @RequestParam(name="b", required=true) String b){
        return myCalculator.addString(a,b);
        }

    @GetMapping("/hi")
    public String sayHi(){
        return "Hi World";
    }


}