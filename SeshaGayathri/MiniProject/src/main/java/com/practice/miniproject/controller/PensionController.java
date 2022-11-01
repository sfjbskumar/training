package com.practice.miniproject.controller;

import com.practice.miniproject.model.PensionModel;
import com.practice.miniproject.service.PensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PensionController {
    @Autowired
    PensionService pensionService;

    //create (admin only)
    //creating post mapping that post the pensioner detail in the database
    @PostMapping("/create/applicant")
    public PensionModel createApplicant(@RequestBody PensionModel pension)
    {
        return pensionService.saveOrUpdate(pension);

    }

    //edit (admin only)
    //creating post mapping that edits applicant details
    @PostMapping("/edit/applicant")
    public int editApplicant(@RequestBody PensionModel pension)
    {
        pensionService.saveOrUpdate(pension);
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
    public List<PensionModel> getAllApplicants()
    {
        return pensionService.getAllPension();
    }

    //applicant can check application info.
    //creating a get mapping that retrieves the detail of a specific applicant
    @GetMapping("/checkApplication/{id}")
    public PensionModel getApplicant(@PathVariable("id") int id)
    {
        return pensionService.getPensionById(id);
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
