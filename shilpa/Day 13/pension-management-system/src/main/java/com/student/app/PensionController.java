package com.student.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PensionController {

    @Autowired
    PensionService pensionService;
    @PostMapping("/create/applicant")
    private String savePension(@RequestBody Pension pension){
        pensionService.saveOrUpadate(pension);
        return pension.getName();
    }
    @PostMapping("/edit/applicant")
    private List<Pension> getAllPension(){ return pensionService.getAllPension(); }

    @GetMapping("/approve/{id}")
    private Pension getPension(@PathVariable("id")int id){return pensionService.getPensionById(id);}

    @GetMapping("/checkStatus/{id}")
    private String getPensionStatus(@PathVariable("id") int id)
    {
        Pension pension1 = pensionService.getPensionById(id);
        int pid= pension1.getId();
        String ptr = Integer.toString(pid);
        String estat = pension1.getEmpStatus();
        String pstat = pension1.getPensionstatus();

        String str = "Id = "+ptr + "\nEmployee Status = "+estat+"\nPension Status = "+pstat;
        return str;
    }

    @GetMapping("/checkBalance/{id}")
    private String getPensionBalance(@PathVariable("id") int id)
    {
        Pension pension1 = pensionService.getPensionById(id);
        int pid= pension1.getId();
        String ptr = Integer.toString(pid);
        int bal = pension1.getBalanceAmount();
        String btr = Integer.toString(bal);
        int inst = pension1.getInstallments();
        String itr = Integer.toString(inst);
        String pmy = pension1.getPensionstarts();
        String str = "Id = "+ptr + "\nBalance = "+btr+"\nInstallment = "+itr+"\nPension Month = "+pmy;
        return str;
    }

    @GetMapping("/checkApplication/{id}")
    private List<Pension> getAllPension(@PathVariable("id")int id){return (List<Pension>) pensionService.getPensionById(id);}

}
