package com.pension.app;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Query;

import com.pension.app.PensionService;
import com.pension.app.Pension;
import com.pension.app.PensionRepository;
import java.util.List;
//import java.util.HashMap;
//import java.util.Map;

@RestController
public class PensionController {
    @Autowired
    PensionService pensionService;
    PensionRepository pensionRepository;

    @GetMapping("/pensions")
    private List<Pension> getAllPension()
    {
        return pensionService.getAllPension();
    }

    @GetMapping("/getPension")
    private void getAllPensions()
    {
         pensionRepository.deactivateUsersNotLoggedInSince();
       // getall.forEach(i->{System.out.println(i);});
    }

    @PostMapping("/createApplicant")
    private int savePension(@RequestBody Pension pension)
    {
        pensionService.saveOrUpdate(pension);
        return pension.getId();
    }

    @PostMapping("/editApplicant")
    private int editPension(@RequestBody Pension pension)
    {
        pensionService.saveOrUpdate(pension);
        return pension.getId();
    }

    @GetMapping("/pension/{id}")
    private Pension getPension(@PathVariable("id") int id)
    {
        return pensionService.getPensionById(id);
    }

    @GetMapping("/checkStatus/{id}")
    private String getPensionStatus(@PathVariable("id") int id)
    {
        Pension pension1 = pensionService.getPensionById(id);
        int pid= pension1.getId();
        String ptr = Integer.toString(pid);
        String estat = pension1.getEmpstatus();
        String pstat = pension1.getPenstatus();

        String str = "Id = "+ptr + "\nEmployee Status = "+estat+"\nPension Status = "+pstat;
        return str;
    }

    @GetMapping("/checkBalance/{id}")
    private String getPensionBalance(@PathVariable("id") int id)
    {
        Pension pension1 = pensionService.getPensionById(id);
        int pid= pension1.getId();
        String ptr = Integer.toString(pid);
        int bal = pension1.getBalance();
        String btr = Integer.toString(bal);
        int inst = pension1.getInstallment();
        String itr = Integer.toString(inst);
        String pmy = pension1.getPenmmyy();
        String str = "Id = "+ptr + "\nBalance = "+btr+"\nInstallment = "+itr+"\nPension Month = "+pmy;
        return str;
    }
    @PutMapping("/issuePension/{id}")
    private String putPension(@PathVariable("id") int id){
        Pension pension1 = pensionService.getPensionById(id);
        String es = pension1.getEmpstatus();
        String ps = pension1.getPenstatus();
        String name = pension1.getName();
        if(es.equals("R") && ps.equals("Y")) {
            int bal = pension1.getBalance();
            int inst = pension1.getInstallment();
            bal = bal - inst;
            pension1.setBalance(bal);
            pensionService.saveOrUpdate(pension1);
            String str = "Pension issued to " + name + "\nAvalaible Balance : " + bal;
            return str;
        }
        else{
            String str = "Pension cannot be issued to "+name+"\nEmployee Status :"+es+"\nPension Status :"+ps;
            return str;
        }
    }

    @PutMapping("/loadBalance/{id}")
    private String putBalance(@PathVariable("id") int id){
        Pension pension1 = pensionService.getPensionById(id);
        String es = pension1.getEmpstatus();
        String ps = pension1.getPenstatus();
        String name = pension1.getName();
        if(es.equals("W") && ps.equals("N")) {
            int bal = pension1.getBalance();
            int inst = pension1.getInstallment();
            bal = bal + inst;
            pension1.setBalance(bal);
            pensionService.saveOrUpdate(pension1);
            String str = "Balance credited to " + name + "\nAvailable Balance : " + bal;
            return str;
        }
        else{
            String str = "Balance cannot be credited to "+name+"\nEmployee Status :"+es+"\nPension Status :"+ps;
            return str;
        }
    }

    @PutMapping("/approve/{id}")
    private String getApprove(@PathVariable("id") int id){
        Pension pension1 = pensionService.getPensionById(id);
        String es = pension1.getEmpstatus();
        if(es.equals("R")) {
            pension1.setPenstatus("Y");
            pensionService.saveOrUpdate(pension1);
            String str = "Pension Approved !";
            return str;
        }
        else{
            String str = "Pension cannot be approved."+"\nEmployee Status :"+es;
            return str;
        }
    }

    @GetMapping("/checkApplication/{id}")
    private Pension getPensionApp(@PathVariable("id") int id)
    {
        return pensionService.getPensionById(id);
    }

    @DeleteMapping("/pension/{id}")
    private void deletePension(@PathVariable("id") int id)
    {
        pensionService.delete(id);
    }

}
