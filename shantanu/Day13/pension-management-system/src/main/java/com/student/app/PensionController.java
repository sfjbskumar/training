package com.student.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PensionController {

    @Autowired
    PensionService pensionService;
    @PostMapping("/create/applicant")
    private String savePension(@RequestBody com.Pension.app.Pension pension){
        pensionService.saveOrUpadate(pension);
        return pension.getName();
    }
    @PostMapping("/edit/applicant")
    private List<com.Pension.app.Pension> getAllPension(){ return pensionService.getAllPension(); }

    @GetMapping("/approve/{id}")
    private Pension getPension(@PathVariable("id")int id){return pensionService.getPensionById(id);}

    @GetMapping("/checkStatus/{id}")
    private Pension getPension(@PathVariable("id")int id){return pensionService.getPensionById(id);}

    @GetMapping("/checkBalance/{id}")
    private Pension getPension(@PathVariable("id")int id){return pensionService.getPensionById(id);}

    @GetMapping("/checkApplication/{id}")
    private List<Pension> getAllPension(@PathVariable("id")int id){return pensionService.getPensionById(id);}

}
