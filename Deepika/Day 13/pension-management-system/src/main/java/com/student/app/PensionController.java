package com.student.app;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class PensionController {
@Autowired
    PensionService pensionService;
    PensionRepository pensionRepository;
    Pension pen;
    List<Pension> pensionList=new ArrayList<>();
    String stat;// variable used for returning string values
    String strID="The ID ";

    //admin created applicant
    @PostMapping("/create/applicant")
    public int savePension(@RequestBody Pension pensions)
    {
        pensionService.saveOrUpdate(pensions);
        return pensions.getId();
    }

    //admin gets all applicant information present in database
    @GetMapping("/pension")
    public List<Pension> getAllPension(){ return pensionService.getAllPension();}

    //admin approves whether applicant is eligible for pension
    @PutMapping("/approve/{id}")
    public String getApproval(@PathVariable("id") int id){
        pen=pensionService.getPensionById(id);
         stat="";
        if(pen.getEmploymentStatus().equals("A")){
            pen.setPensionStatus("N");
            pensionService.saveOrUpdate(pen);
            stat= "Pension not approved";
        }else if(pen.getEmploymentStatus().equals("R")){
            pen.setPensionStatus("Y");
            pensionService.saveOrUpdate(pen);
            stat= "Pension approved";
        }
        return stat;
    }

    //admin edits applicant
    @PutMapping("/editApplicant")
    public int editPension(@RequestBody Pension pension)
    {
        pensionService.saveOrUpdate(pension);
        return pension.getId();
    }

    //admin issues pension for one applicant by their id
    @PutMapping("/issuePensionById/{id}")
    public String issuePensionById(@PathVariable int id)
    {
         stat="";
        pen= pensionService.getPensionById(id);
        if(pen.getEmploymentStatus().equals("A")&&pen.getPensionStatus().equals("N")){
            stat=strID+pen.getId()+" is not eligible to get Pension";
        }else if(pen.getEmploymentStatus().equals("R")&&pen.getPensionStatus().equals("Y")){
            int bal=pen.getBalance();
            bal=bal-pen.getInstallment();
            pen.setBalance(bal);
            pensionService.saveOrUpdate(pen);
            stat=strID+pen.getId()+" has Balance "+bal+" Installment paid "+pen.getInstallment();
        }
        return stat;
    }

    //admin issues pension for all applicant who are retired
    @PutMapping("/issuePensions")
    public String issuePension()
    {
        int i=0;
         stat="";
        pensionList=getAllPension();
        for(Pension p:pensionList){
            if((p.getEmploymentStatus().equals("R"))&&(p.getPensionStatus().equals("Y"))){
                int bal=p.getBalance();
                bal=bal-p.getInstallment();
                p.setBalance(bal);
                pensionService.saveOrUpdate(p);
                i=1;
            }
        }
        if(i==1){
            stat="Pension updated";
        }else if(i==0){
            stat="No Pension updated";
        }
        return stat;
    }


    //here admin loads balance of one applicant by their id
    @PutMapping("/loadBalanceById/{id}")
    public String loadPensionById(@PathVariable int id)
    {
        stat="";
        pen= pensionService.getPensionById(id);
        if(pen.getEmploymentStatus().equals("R")&&pen.getPensionStatus().equals("Y")){
            stat=strID+pen.getId()+" are not eligible to get Pension";
        }else if(pen.getEmploymentStatus().equals("A")&&pen.getPensionStatus().equals("N")){
            int bal=pen.getBalance();
            bal=bal+pen.getInstallment();
            pen.setBalance(bal);
            pensionService.saveOrUpdate(pen);
            stat=strID+pen.getId()+" has Balance "+bal+"after Installment paid "+pen.getInstallment();
        }
        return stat;
    }
    //admin loads balance for all applicant who are employeed
    @PutMapping("/loadBalance")
    public String loadBalance(){
        pensionList.clear();
        pensionList=getAllPension();
        int i=0;
         stat="";
        pensionList=getAllPension();
        for(Pension p:pensionList){
            if((p.getEmploymentStatus().equals("A"))&&(p.getPensionStatus().equals("N"))){
                int bal=p.getBalance();
                bal=bal+p.getInstallment();
                p.setBalance(bal);
                pensionService.saveOrUpdate(p);
                i=1;
            }
        }
        if(i==1){
            stat="Balance Loaded";
        }else if(i==0){
            stat="No Balance Loaded";
        }
        return stat;
    }

    //admin delete applicant information
    @DeleteMapping("/delete/applicant/{id}")
    public String deletePensionById(@PathVariable int id){
        pensionService.delete(id);
        return "Id deleted";
    }

    //applicant checks their application
    @GetMapping("/checkApplication/{id}")
    public String getPensionById(@PathVariable("id") int id)
    {

        return "Your Application is "+pensionService.getPensionById(id);
    }

    //applicant checks their balance
    @GetMapping("/checkBalance/{id}")
    public String getPensionBalanceById(@PathVariable("id") int id)
    {
        pen= pensionService.getPensionById(id);
        return "Your Balance is : "+pen.getBalance();
    }

    //applicant checks whether their pension and employment status
    @GetMapping("/checkStatus/{id}")
    public String getPensionStatusById(@PathVariable("id") int id)
    {
        pen= pensionService.getPensionById(id);
        String empStatus=(pen.getEmploymentStatus().equals("A"))?"Working (A)":"Retired (R)";
        String penStatus=(pen.getPensionStatus().equals("Y"))?"Eligible (Y)":"Not Eligible (N)";

        return "employee status:"+empStatus+" pension status: "+penStatus;
    }

}