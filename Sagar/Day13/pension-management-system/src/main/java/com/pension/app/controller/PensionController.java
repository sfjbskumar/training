package com.pension.app.controller;

import com.pension.app.model.Pension;
import com.pension.app.repo.PensionRepository;
import com.pension.app.service.PensionService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PensionController {
    @Autowired
    PensionService pension;
   // Pension pen;
    //PensionRepository repository;

    @PostMapping("/add")
    private @NotNull String createProfile(@RequestBody Pension pension1)
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
    private @NotNull String updateEmp(@RequestBody Pension pension1)
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

    @GetMapping("/add/penAmt")
    private @NotNull String addMoneyInPensionAcc(@PathVariable("id") int id)
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
    private @NotNull String getBalance(@PathVariable("id") int id)
    {
        Pension pension1 = pension.getById(id);
        return "Balance Amount is:"+pension1.getBal();
    }

    @PostMapping("/approve/{id}")
    private @NotNull String approveEmp(@PathVariable("id") int id)
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
    private @NotNull String issuePension(@PathVariable("id") int id)
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
    private @NotNull String lastPension(@PathVariable("id") int id)
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


}
