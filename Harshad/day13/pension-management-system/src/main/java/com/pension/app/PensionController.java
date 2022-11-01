package com.pension.app;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
public class PensionController {
    @Autowired
    PensionService pensionService;
    PensionRepository pensionRepository;


    private static final String EMPSTAT = "\nEmployee Status :";

    @GetMapping("/pensions")
    public List<Pension> getAllPension()
    {
        return pensionService.getAllPension();
    }

    @GetMapping("/getPension")
    public List<Pension> getAllPensions()
    {
        return pensionRepository.getPensions();
    }

    @PostMapping("/createApplicant")
    public Pension createApplicant(@RequestBody Pension pension)
    {
        return pensionService.saveOrUpdate(pension);

    }

    @PostMapping("/editApplicant")
    public int editPension(@RequestBody Pension pension1)
    {
        pensionService.saveOrUpdate(pension1);
        return pension1.getId();
    }

    @GetMapping("/pension/{id}")
    public Pension getPension(@PathVariable("id") int id)
    {
        return pensionService.getPensionById(id);
    }

    @GetMapping("/checkStatus/{id}")
    public String getPensionStatus(@PathVariable("id") int id)
    {
        Pension pension1 = pensionService.getPensionById(id);
        int pid= pension1.getId();
        String ptr = Integer.toString(pid);
        String estat = pension1.getEmpstatus();
        String pstat = pension1.getPenstatus();

        return "Id = "+ptr+EMPSTAT+estat+"\nPension Status = "+pstat;

    }

    @GetMapping("/checkBalance/{id}")
    public String getPensionBalance(@PathVariable("id") int id)
    {
        Pension pension1 = pensionService.getPensionById(id);
        int pid= pension1.getId();
        String ptr = Integer.toString(pid);
        int bal = pension1.getBalance();
        String btr = Integer.toString(bal);
        int inst = pension1.getInstallment();
        String itr = Integer.toString(inst);
        String pmy = pension1.getPenmmyy();
        return "Id = "+ptr + "\nBalance = "+btr+"\nInstallment = "+itr+"\nPension Month = "+pmy;

    }

    @GetMapping("/checkApplication/{id}")
    public Pension getPensionApp(@PathVariable("id") int id)
    {
        return pensionService.getPensionById(id);
    }

    @DeleteMapping("/pension/{id}")
    public String deletePension(@PathVariable("id") int id)
    {

        return pensionService.delete(id);
    }

    @GetMapping("/issuePensions")
    public String issuePensions(){
        int f=0;
        List<Pension> list =pensionService.getAllPension();


        for(int i=0;i<list.size();i++) {
            Pension pension1 = list.get(i);
            String es = pension1.getEmpstatus();
            String ps = pension1.getPenstatus();

            if (es.equals("R") && ps.equals("Y")) {
                int bal = pension1.getBalance();
                int inst = pension1.getInstallment();
                bal = bal - inst;
                pension1.setBalance(bal);
                pensionService.saveOrUpdate(pension1);
                f++;
            }

        }
        if(f>0){
            return "Pension Updated !";
        }
        else{
            return "Pensions are not Updated !";
        }


    }
    @GetMapping("/loadBalance")
    public String loadPensions(){
        int f=0;
        List<Pension> list = pensionService.getAllPension();

        for(int i=0;i<list.size();i++) {
            Pension pension1 = list.get(i);
            String es = pension1.getEmpstatus();
            String ps = pension1.getPenstatus();
            if (es.equals("W") && ps.equals("N")) {
                int bal = pension1.getBalance();
                int inst = pension1.getInstallment();
                bal = bal + inst;
                pension1.setBalance(bal);
                pensionService.saveOrUpdate(pension1);
                f++;
            }

        }
        if(f>0){
            return "Balance credited !";
        }
        else{
            return "Balance not credited !";
        }
    }

    @GetMapping("/approve")
    public String aPensions(){
        int f=0;
        List<Pension> list = pensionService.getAllPension();

        for(int i=0;i<list.size();i++) {
            Pension pension1 = list.get(i);
            String es = pension1.getEmpstatus();
            String ps = pension1.getPenstatus();
            if (es.equals("R") && ps.equals("N")) {
                pension1.setPenstatus("Y");
                pensionService.saveOrUpdate(pension1);
                f++;
            }

        }
        if(f>0){
            return "Pension approved !";
        }
        else{
            return "Pension cannot be approved !";
        }
    }

}
