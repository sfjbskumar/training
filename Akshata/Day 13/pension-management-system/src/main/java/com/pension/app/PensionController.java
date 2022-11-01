package com.pension.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class PensionController {

    @Autowired
    PensionService pensionService;





    @GetMapping("/pension/{id}")
    public Pension getPension(@PathVariable("id") int id)
    {
        return pensionService.getPensionById(id);
    }

    @GetMapping("/checkStatus/{id}")
    public String[] getPensionStatus(@PathVariable("id") int id){
        Pension p = pensionService.getPensionById(id);
        int gid= p.getId();
        String[] str= new String[3];
        str[0]=Integer.toString(gid);
        str[1] = p.getEstatus();
        str[2] = p.getPstatus();

        return str;

    }

    @GetMapping("/checkBalance/{id}")
    public String[] getPensionBalance(@PathVariable("id") int id){
        Pension p = pensionService.getPensionById(id);
        int gid= p.getId();
        int ginst=p.getInstallment();
        int gbmt=p.getBalamt();
        String[] str= new String[4];
        str[0]=Integer.toString(gid);
        str[1]=Integer.toString(ginst);
        str[2] = Integer.toString(gbmt);
        str[3] = p.getPmonth();

        return str;

    }
    @GetMapping("/checkApplication/{id}")
    public Pension getPensionApplication(@PathVariable("id") int id){
        return pensionService.getPensionById(id);

    }


    @PostMapping("/create/applicant")
    public int CreatePension(@RequestBody Pension pension){
        pensionService.saveOrUpdate(pension);
        return pension.getId();
    }



    @PostMapping("/edit/applicant")
    public int EditApplication(@RequestBody Pension pension) {
        pensionService.saveOrUpdate(pension);
        return pension.getId();

    }


    @PutMapping("/issuePension/{id}")
    public String putPension(@PathVariable("id") int id){
        Pension p = pensionService.getPensionById(id);
        String est = p.getEstatus();
        String pst = p.getPstatus();
        int bmt = p.getBalamt();
        int ins = p.getInstallment();
        if((est.equals("R")) && (pst.equals("Y"))) {
            bmt = bmt - ins;
            p.setBalamt(bmt);
            pensionService.saveOrUpdate(p);

            return"Balance:" + (String.valueOf(bmt));
        }
        else{
            return ("No Pension issued");
        }
    }

    @PutMapping("/loadPension/{id}")
    public String putBalance(@PathVariable("id") int id){
        Pension p = pensionService.getPensionById(id);
        String est = p.getEstatus();
        String pst = p.getPstatus();
        int bmt = p.getBalamt();
        int ins = p.getInstallment();
        if((est.equals("A")) && (pst.equals("N"))) {
            bmt = bmt+ ins;
            p.setBalamt(bmt);
            pensionService.saveOrUpdate(p);
            return "Balance:" + (String.valueOf(bmt));
        }
        else{
            return ("No Pension loaded");
        }
    }



    @PutMapping("/approve/{id}")
    public  String ApprovePension(@PathVariable("id") int id){
        Pension p = pensionService.getPensionById(id);
        String est=p.getEstatus();
        if(est.equals("R")) {
            p.setPstatus("Y");
            pensionService.saveOrUpdate(p);
            return ("Approved");
        }
        else {
            return ("Declined");
        }

    }







}
