package com.practice.miniproject.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.practice.miniproject.service.PensionService;
import com.practice.miniproject.model.PensionModel;
import com.practice.miniproject.PensionRepository;
import java.util.List;
//import java.util.HashMap;
//import java.util.Map;
@RestController
public class PensionController {
    @Autowired
    PensionService pensionService;
    PensionRepository pensionRepository;

    @GetMapping("/pensions")
    public List<PensionModel> getAllPension()
    {
        return pensionService.getAllPension();
    }

 
    @PostMapping("/create_Applicant")
    public int savePension(@RequestBody PensionModel pension)
    {
        pensionService.saveOrUpdate(pension);
        return pension.getId();
    }

    @PostMapping("/edit_Applicant")
    public int editPension(@RequestBody PensionModel pension)
    {
        pensionService.saveOrUpdate(pension);
        return pension.getId();
    }

    @GetMapping("/pension/{id}")
    public PensionModel getPension(@PathVariable("id") int id)
    {
        return pensionService.getPensionById(id);
    }

    @GetMapping("/check_PenStatus/{id}")
    public String getPensionStatus(@PathVariable("id") int id)
    {
        PensionModel pension1 = pensionService.getPensionById(id);
        String str = "The pension status of your Id = "+Integer.toString(pension1.getId())+"is"+
                    pension1.getPenstatus();
        return str;
    }

    @GetMapping("/check_Balance/{id}")
    public String getPensionBalance(@PathVariable("id") int id)
    {
        PensionModel pension1 = pensionService.getPensionById(id);
        String str = "Id = "+Integer.toString(pension1.getId()) +
                "\nBalance = "+Integer.toString(pension1.getBalance())+
                "\nInstallment = "+ Integer.toString(pension1.getInstallment())+
                "\nPension Month = "+pension1.getPenmmyy();
        return str;
    }
    @PutMapping("/issue_Pension/{id}")
    public String putPension(@PathVariable("id") int id){
        PensionModel pension1 = pensionService.getPensionById(id);
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

    @PutMapping("/CreditRemBalance/{id}")
    public String putBalance(@PathVariable("id") int id){
        PensionModel pension1 = pensionService.getPensionById(id);
        String empS = pension1.getEmpstatus();
        String penS = pension1.getPenstatus();
        String name = pension1.getName();
        if(empS.equals("W") && penS.equals("N")) {
            int bal = pension1.getBalance();
            int inst = pension1.getInstallment();
            bal = bal + inst;
            pension1.setBalance(bal);
            pensionService.saveOrUpdate(pension1);
            String str = "Balance credited to " + name +"'s account" +"\nAvailable Balance : " + bal;
            return str;
        }
        else{
            String str = "Balance cannot be credited to "+name+"\nEmployee Status :"+empS+"\nPension Status :"+penS;
            return str;
        }
    }

    @PutMapping("/approve/{id}")
    public String getApprove(@PathVariable("id") int id){
        PensionModel pension1 = pensionService.getPensionById(id);
        String empS = pension1.getEmpstatus();
        if(empS.equals("R")) {
            pension1.setPenstatus("Y");
            pensionService.saveOrUpdate(pension1);
            String str = "Pension Approved...!";
            return str;
        }
        else{
            String str = "Pension cannot be approved as Employee Status is."+empS;
            return str;
        }
    }

    @GetMapping("/check_Application/{id}")
    public PensionModel getPensionApplication(@PathVariable("id") int id)
    {
        return pensionService.getPensionById(id);
    }

    @DeleteMapping("/pension/{id}")
    public void deletePension(@PathVariable("id") int id)
    {
        pensionService.delete(id);

    }

}



