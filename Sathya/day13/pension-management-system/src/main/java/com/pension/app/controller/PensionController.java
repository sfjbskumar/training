package com.pension.app.controller;

import java.util.List;

import com.pension.app.service.PensionService;
import com.pension.app.model.Pension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PensionController {

    @Autowired
    PensionService pensionService;

    //create (admin only)
    //creating post mapping that post the pensioner detail in the database
    @PostMapping("/create/applicant")
    public Pension createApplicant(@RequestBody Pension pension)
    {
        return pensionService.createOrUpdate(pension);

    }

    //edit (admin only)
    //creating post mapping that edits applicant details
    @PostMapping("/edit/applicant")
    public int editApplicant(@RequestBody Pension pension)
    {
        pensionService.createOrUpdate(pension);
        return pension.getId();
    }



    //checkStatus id, emp and pension status (applicant)
    @GetMapping("/checkStatus/{id}")
    public String checkStatus(@PathVariable("id") int id){
        return pensionService.getStatus(id);
    }


    //checkBalance (applicant)
    @GetMapping("/checkBalance/{id}")
    public String checkBalance(@PathVariable("id") int id){
        return pensionService.getBalanceDetails(id);
    }

    //creating a get mapping that retrieves all applicants' data
    @GetMapping("/get/applicants")
    public List<Pension> getAllApplicants()
    {
        return pensionService.getAllApplicants();
    }

    //applicant can check application info.
    //creating a get mapping that retrieves the detail of a specific applicant
    @GetMapping("/checkApplication/{id}")
    public Pension getApplicant(@PathVariable("id") int id)
    {
        return pensionService.getApplicantById(id);
    }

    //creating a delete mapping that deletes a specific pensioner
    @DeleteMapping("/delete/applicant/{id}")
    public String deleteApplicant(@PathVariable("id") int id)
    {
        return pensionService.delete(id);

    }

    //admin only module
    //approve application for Retired employees
    @PostMapping("/approve/{id}")
    public String approveApplication(@PathVariable("id") int id){
        return pensionService.approveApplication(id);
    }


    //issue pension to retired employees (admin only)
    @PostMapping("/issuePension")
    public void issuePension(){
        pensionService.issuePension();
    }

    //load pension to active employees (admin only)
    @PostMapping("/loadPension")
    public void loadPension(){
        pensionService.loadPension();
    }

}
