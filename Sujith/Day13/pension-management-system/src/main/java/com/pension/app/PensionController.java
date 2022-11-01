package com.pension.app;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@RestController
public class PensionController {
    @Autowired
    PensionService pensionService;
    PensionRepository pensionRepository;




    @PostMapping("/createPension")
    public Pension savePension(@RequestBody Pension pension)
    {
        return pensionService.saveOrUpdate(pension);
    }


    @PostMapping("/editPension")
    public int editPension(@RequestBody Pension pen)
    {
        pensionService.saveOrUpdate(pen);
        return pen.getId();
    }

    @GetMapping("/get/allPension")
    public List<Pension> getAllPension()
    {
        return pensionService.getAllPension();
    }



    @GetMapping("/pension/{id}")
    public Pension getPension(@PathVariable("id") int id)
    {
        return pensionService.getPensionById(id);
    }

    @GetMapping("/issuePensions")
    public String issuePensions(){
        int j=0;
        List<Pension> list = pensionService.getAllPension();


        for(int i=0;i<list.size();i++) {
            Pension pen = list.get(i);
            String eStatus = pen.getEmpStatus();
            String pApproval = pen.getPenApproval();

            if (eStatus.equals("R") && pApproval.equals("Y")) {
                int bal = pen.getBalance();
                int install = pen.getInstallment();
                bal = bal - install;
                pen.setBalance(bal);
                pensionService.saveOrUpdate(pen);
                j++;
            }

        }
        if(j>0){
            return "Pension Issued";
        }
        else{
            return "Pensions are not issued";
        }
    }

    @PutMapping("/issuePension/{id}")
    public String putPension(@PathVariable("id") int id){
        Pension pen = pensionService.getPensionById(id);
        String eStatus = pen.getEmpStatus();
        String pApproval = pen.getPenApproval();
        String name = pen.getName();
        if(eStatus.equals("R") && pApproval.equals("Y")) {
            int bal = pen.getBalance();
            int install = pen.getInstallment();
            bal = bal - install;
            pen.setBalance(bal);
            pensionService.saveOrUpdate(pen);
            return  "Pension issued to "+name;

        }
        else{
            return "Pension can't be issued to "+name+"\nEmployee Status :"+eStatus+"\n Pension Status :"+pApproval;
        }
    }

    @PutMapping("/loadBalance/{id}")
    public String putBalance(@PathVariable("id") int id){
        Pension pen = pensionService.getPensionById(id);
        String eStatus = pen.getEmpStatus();
        String pApproval = pen.getPenApproval();
        String name = pen.getName();
        if(eStatus.equals("A") && pApproval.equals("N")) {
            int bal = pen.getBalance();
            int install = pen.getInstallment();
            bal = bal + install;
            pen.setBalance(bal);
            pensionService.saveOrUpdate(pen);
            return "Balance credited for " + name + "\nAvailable Balance : " + bal;

        }
        else{
            return "Balance can't be credited to "+name+"\nPension Status :"+eStatus+"\nPension Status :"+pApproval;

        }
    }

    @GetMapping("/loadBalance")
    public String loadBalance(){
        int j=0;
        List<Pension> list = pensionService.getAllPension();

        for(int i=0;i<list.size();i++) {
            Pension pen = list.get(i);
            String eStatus = pen.getEmpStatus();
            String pApproval = pen.getPenApproval();
            if (eStatus.equals("W") && pApproval.equals("N")) {
                int bal = pen.getBalance();
                int install = pen.getInstallment();
                bal = bal + install;
                pen.setBalance(bal);
                pensionService.saveOrUpdate(pen);
                j++;
            }

        }
        if(j>0){
            return "Balance credited!";
        }
        else{
            return "Balance not credited!";
        }
    }

    @PutMapping("/approve/{id}")
    public String getApprove(@PathVariable("id") int id){
        Pension pen = pensionService.getPensionById(id);
        String eStatus = pen.getEmpStatus();
        if(eStatus.equals("R")) {
            pen.setPenApproval("Y");
            pensionService.saveOrUpdate(pen);
            return  "Pension Approved";

        }
        else{
            return "Pension can't be approved";

        }
    }

    @GetMapping("/applicantStatus/{id}")
    public String getPensionStatus(@PathVariable("id") int id)
    {
        Pension pen = pensionService.getPensionById(id);
        int appId= pen.getId();
        String eStatus = pen.getEmpStatus();
        String pApproval = pen.getPenApproval();

        return "Id = "+appId+"\nEmployee Status = "+eStatus+"\nPension Status = "+pApproval;

    }

    @GetMapping("/checkBalance/{id}")
    public String getPensionBalance(@PathVariable("id") int id)
    {
        Pension pen = pensionService.getPensionById(id);
        int appId= pen.getId();
        int bal = pen.getBalance();
        int install = pen.getInstallment();
        String pMonth = pen.getPenMmYy();
        return "Id = "+appId + "\nBalance = "+bal+"\nInstallment = "+install+"\nPension Month = "+pMonth;

    }




    @GetMapping("/checkApplication/{id}")
    public Pension getPensionApp(@PathVariable("id") int id)
    {
        return pensionService.getPensionById(id);
    }

    @DeleteMapping("/deletePension/{id}")
    public void deletePension(@PathVariable("id") int id)
    {
        pensionService.delete(id);
    }





}
