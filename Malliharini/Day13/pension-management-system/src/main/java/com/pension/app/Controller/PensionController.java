package com.pension.app.Controller;

import com.pension.app.Repository.PensionRepository;
import com.pension.app.Service.PensionService;
import com.pension.app.model.Pension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PensionController {
     @Autowired
    PensionService pensionService;
   PensionRepository pensionRepository;

    @PostMapping("/createApplicant")
    private int savePensionApplicant(@RequestBody Pension applicant)
    {
        pensionService.saveOrUpdate(applicant);
        return applicant.getApplicant_id();
    }
    @GetMapping("/pensions")
    private List<Pension> applicant_info()
    {
        return pensionService.applicant_info();
    }

    @GetMapping("/getPension")
    private void getAllPensions()
    {
        pensionRepository.deactivateUsersNotLoggedInSince();
        // getall.forEach(i->{System.out.println(i);});
    }
    @PostMapping("/editApplicant")
    private int editPension(@RequestBody Pension pension)
    {
        pensionService.saveOrUpdate(pension);
        return pension.getApplicant_id();
    }
    @GetMapping("/pension/{id}")
    private Pension getPension(@PathVariable("id") int id)
    {
        return pensionService.getapplicantById(id);
    }

    @GetMapping("/checkstatus/{id}")
    private String getPensionStatus(@PathVariable("id") int applicant_id)
    {
        Pension pension1 = pensionService.getapplicantById(applicant_id);
        int id= pension1.getApplicant_id();
        String strid = Integer.toString(id);
        String emp_status = pension1.getEmp_status();
        String pen_status = pension1.getPension_status();

        return "Id = "+strid + "\nEmployee Status = "+emp_status+"\nPension Status = "+pen_status;
    }
    @GetMapping("/checkBalance/{id}")
    private String checkbalance(@PathVariable("id") int applicant_id)
    {
        Pension pension1 = pensionService.getapplicantById(applicant_id);
        int id= pension1.getApplicant_id();
        String strid = Integer.toString(id);
        int bal = pension1.getBalance_amount();
        String strbal = Integer.toString(bal);
        int inst = pension1.getInstallment();
        String strinst = Integer.toString(inst);
        String pmy = pension1.getLast_pension_issue();
        String str = "Id = "+strid + "\nBalance = "+strbal+"\nInstallment = "+strinst+"\nPension Month = "+pmy;
        return str;
    }
    @PutMapping("/issuePension/{id}")
    private String putPension(@PathVariable("id") int applicant_id){
        Pension pension1 = pensionService.getapplicantById(applicant_id);
        String es = pension1.getEmp_status();
        String ps = pension1.getPension_status();
        String name = pension1.getApplicant_name();
        if(es.equals("R") && ps.equals("Y")) {
            int bal = pension1.getBalance_amount();
            int inst = pension1.getInstallment();
            bal = bal - inst;
            pension1.setBalance_amount(bal);
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
    private String putBalance(@PathVariable("id") int applicant_id){
        Pension pension1 = pensionService.getapplicantById(applicant_id);
        String es = pension1.getEmp_status();
        String ps = pension1.getPension_status();
        String name = pension1.getApplicant_name();
        if(es.equals("W") && ps.equals("N")) {
            int bal = pension1.getBalance_amount();
            int inst = pension1.getInstallment();
            bal = bal + inst;
            pension1.setBalance_amount(bal);
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
    private String getApprove(@PathVariable("id") int applicant_id){
        Pension pension1 = pensionService.getapplicantById(applicant_id);
        String es = pension1.getEmp_status();
        if(es.equals("R")) {
            pension1.setPension_status("Y");
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
    private Pension getPensionApp(@PathVariable("id") int applicant_id)
    {
        return pensionService.getapplicantById(applicant_id);
    }

}
