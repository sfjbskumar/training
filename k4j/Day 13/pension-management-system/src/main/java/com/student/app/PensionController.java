package com.student.app;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PensionController {

    public Map<String,Pension> pensionMap= new HashMap<String,Pension>();

    @PostMapping("save/Pension")
    public Pension SavePension(@RequestBody Pension pension){
        String name= Pension.getName();
        pensionMap.put(name,Pension);
        return pension;
    }

    @PutMapping("update/student")
    public Pension updatePension(@RequestParam String name,@RequestParam String std){
        Pension result= pensionMap.get(name);
        if (result == null) {
            Pension pension= new Pension("id","name","age", "balance_amount","phone_no","emp_status","pension_status","pension_mmyy");
            pension.setStd(std);
            pensionMap.put(name,pension);
            return pension;
        }else {
            result.setStd(std);
            pensionMap.put(name, result);
            return result;
        }

    }



}
