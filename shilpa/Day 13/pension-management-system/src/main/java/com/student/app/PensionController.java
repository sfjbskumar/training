package com.student.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PensionController {

    @Autowired
    PensionService ps;

    @PostMapping("/create/applicant")
    public Pension createApplicant(@RequestBody Pension pension)
    {
       return  ps.createOrUpdate(pension);
    }

    @PostMapping("/edit/applicant")
    public int editApplicant(@RequestBody Pension pension)
    {
        ps.createOrUpdate(pension);
        return pension.getId();
    }

    @GetMapping("/checkStatus/{id}")
    public String checkStatus(@PathVariable("id") int id){
        return ps.getStatus(id);
    }

    @GetMapping("/getapplicant/{id}")
    public Pension getApplicantById(@PathVariable("id") int id){
        return ps.getApplicantById(id);
    }


    //checkBalance (applicant)
    @GetMapping("/checkBalance/{id}")
    public int checkBalance(@PathVariable("id") int id){
        return ps.getBalanceDetails(id);
    }

    @DeleteMapping("/delete/applicant/{id}")
    public String deleteApplicant(@PathVariable("id") int id)
    {
        return ps.delete(id);

    }
    @GetMapping("/get/applicants")
    public List<Pension> getAllApplicants()
    {
        return ps.getAllApplicants();
    }

    @PostMapping("/approve/{id}")
    public String approveApplication(@PathVariable("id") int id){
        return ps.approveApplication(id);
    }


    //issue pension to retired employees (admin only)
    @PostMapping("/issuePension")
    public void issuePension(){
        ps.issuePension();
    }

    //load pension to active employees (admin only)
    @PostMapping("/loadPension")
    public void loadPension(){
        ps.loadPension();
    }

}




