package com.pension.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping
public class PensionController {
    @Autowired
    PensionService pension;


    @PostMapping("/add")
    private String createProfile(@RequestBody Pension pension1)
    {
        pension.saveEmp(pension1);
        return pension1.getId()+"Saved Successfully";
    }
    @GetMapping("/all/employee")
    private List<Pension> getAllData()
    {
        return pension.getAllData();
    }
    @GetMapping("/employee/{id}")
    private Pension getEmpById(@PathVariable("id") int id)
    {
        return pension.getById(id);
    }
    @PostMapping("/update")
    private String updateEmp(@RequestBody Pension pension1)
    {
        pension.saveEmp(pension1);
        return pension1.getId()+"Updated";
    }

    @GetMapping("/penStatus/{id}")
    private String getPenStatus(@PathVariable("id") int id)
    {
        Pension pension1 = pension.getById(id);
        return pension1.getPenStatus();
    }

    @GetMapping("/empStatus/{id}")
    private String getEmpStatus(@PathVariable("id") int id)
    {
        Pension pension1 = pension.getById(id);
        return pension1.getEmpStatus();
    }

    @PutMapping("/add/penAmt")
    private String addMoneyInPensionAcc(@PathVariable("id") int id)
    {
        Pension pension1 = pension.getById(id);
        if(pension1.getEmpStatus().equals("A") && pension1.getPenStatus().equals("Y") )
        {
            int bal = pension1.getBal();
            int installment = pension1.getInstallment();
            bal = bal + installment;
            pension1.setBal(bal);
            return "Money added successfully";
        }
        else {
            return "Money cannot be added";
        }
    }

    @GetMapping("/getBalance/{id}")
    private String getBalance(@PathVariable("id") int id)
    {
        Pension pension1 = pension.getById(id);
        return "Balance Amount is:"+pension1.getBal();
    }

    @PutMapping("/approve/{id}")
    private String approveEmp(@PathVariable("id") int id)
    {
        Pension pension1 = pension.getById(id);
        if(pension1.getEmpStatus().equals("R"))
        {
            pension1.setPenStatus("Y");
            return pension.getById(id)+"Approved";
        }
        else
        {
            return "Not Approved";
        }
    }

    @PostMapping("/issue/pension/{id}")
    private String issuePension(@PathVariable("id") int id)
    {
        Pension pension1 = pension.getById(id);
        if(pension1.getEmpStatus().equals("R") && pension1.getPenStatus().equals("Y") )
        {
            int newBal = pension1.getBal();
            int installment= pension1.getInstallment();
            newBal = newBal - installment;
            pension1.setBal(newBal);
            pension.saveEmp(pension1);
            return pension1.getId()+"is issued by amount"+ pension1.getInstallment();
        }
        else{
            return "Pension cannot be issued";
        }
    }

    @GetMapping("/lastPension")
    private String lastPension(@PathVariable("id") int id)
    {
        Pension pension1 = pension.getById(id);
        if(pension1.getEmpStatus().equals("R") && pension1.getPenStatus().equals("Y") )
        {
            return "Last pension issued on:"+pension1.getLastPension()+"of amount:"+pension1.getInstallment()+"Balance is:"+pension1.getBal();
        }
        else{
            return "No pension issued";
        }
    }
    @DeleteMapping("/delete/pension/{id}")
    public void deletePension(@PathVariable("id") int id)
    {
        pension.deleteEmp(id);
    }

}
