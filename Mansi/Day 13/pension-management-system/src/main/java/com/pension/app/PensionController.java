package com.pension.app;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;





import java.util.List;


@RestController
public class PensionController {
    @Autowired
    PensionService pensionService;
    PensionRepository pensionRepository;

    @GetMapping("/pensions")
    List<Pension> getAllPension()
    {
        return pensionService.getAllPension();
    }

    @GetMapping("/getPension")
    List<Pension> getAllPensions()
    {
    return pensionRepository.getPensions();

    }

    @PostMapping("/createApplicant")
    int savePension(@RequestBody Pension pension)
    {
        pensionService.saveOrUpdate(pension);
        return pension.getId();
    }

    @PostMapping("/editApplicant")
    int editPension(@RequestBody Pension pension2)
    {
        pensionService.saveOrUpdate(pension2);
        return pension2.getId();
    }

    @GetMapping("/pension/{id}")
    Pension getPension(@PathVariable("id") int id)
    {
        return pensionService.getPensionById(id);
    }

    @GetMapping("/checkStatus/{id}")
    String getPensionStatus(@PathVariable("id") int id)
    {
        Pension pension1 = pensionService.getPensionById(id);
        int pid= pension1.getId();
        String ptr = Integer.toString(pid);
        String es = pension1.getEmpStatus();
        String ps = pension1.getPenStatus();

        return "Id = "+ptr + "\nEmployee Status = "+es+"\nPension Status = "+ps;

    }

    @GetMapping("/checkBalance/{id}")
    String getPensionBalance(@PathVariable("id") int id)
    {
        Pension pension1 = pensionService.getPensionById(id);
        int pid= pension1.getId();
        String ptr = Integer.toString(pid);
        int bal = pension1.getBalance();
        String btr = Integer.toString(bal);
        int inst = pension1.getInstallment();
        String itr = Integer.toString(inst);
        String pmy = pension1.getPenMmYy();
         return "Id = "+ptr + "\nBalance = "+btr+"\nInstallment = "+itr+"\nPension Month = "+pmy;

    }
    @PutMapping("/issuePension/{id}")
    String putPension(@PathVariable("id") int id){
        Pension pension1 = pensionService.getPensionById(id);
        String es = pension1.getEmpStatus();
        String ps = pension1.getPenStatus();
        String name = pension1.getName();
        if(es.equals("R") && ps.equals("Y")) {
            int bal = pension1.getBalance();
            int inst = pension1.getInstallment();
            bal = bal - inst;
            pension1.setBalance(bal);
            pensionService.saveOrUpdate(pension1);
            return "Pension issued to " + name + "\nAvailable Balance : " + bal;

        }
        else{
            return "Pension cannot be issued to "+name+"\nEmployee Status :"+es+"\nPension Status :"+ps;

        }
    }

    @PutMapping("/loadBalance/{id}")
    String putBalance(@PathVariable("id") int id){
        Pension pension1 = pensionService.getPensionById(id);
        String es = pension1.getEmpStatus();
        String ps = pension1.getPenStatus();
        String name = pension1.getName();
        if(es.equals("W") && ps.equals("N")) {
            int bal = pension1.getBalance();
            int inst = pension1.getInstallment();
            bal = bal + inst;
            pension1.setBalance(bal);
            pensionService.saveOrUpdate(pension1);
            return "Balance credited to " + name + "\nAvailable Balance : " + bal;

        }
        else{
            return "Balance cannot be credited to "+name+"\nEmployee Status :"+es+"\nPension Status :"+ps;

        }
    }

    @PutMapping("/approve/{id}")
    String getApprove(@PathVariable("id") int id){
        Pension pension1 = pensionService.getPensionById(id);
        String es = pension1.getEmpStatus();
        if(es.equals("R")) {
            pension1.setPenStatus("Y");
            pensionService.saveOrUpdate(pension1);
           return  "Pension Approved !";

        }
        else{
            return "Pension cannot be approved."+"\nEmployee Status :"+es;

        }
    }

    @GetMapping("/checkApplication/{id}")
    Pension getPensionApp(@PathVariable("id") int id)
    {
        return pensionService.getPensionById(id);
    }

    @DeleteMapping("/pension/{id}")
    void deletePension(@PathVariable("id") int id)
    {
        pensionService.delete(id);
    }

    @GetMapping("/issuePensions")
    String putPensions(){
        int f=0;
        List<Pension> list = pensionService.getAllPension();

        for(int i=0;i<list.size();i++) {
            Pension pension1 =list.get(i);
            String es = pension1.getEmpStatus();
            String ps = pension1.getPenStatus();

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
    String loadPensions(){
        int f=0;
        List<Pension> list;
        list=pensionService.getAllPension();

        for(int i=0;i<list.size();i++) {
            Pension pension1 = list.get(i);
            String es = pension1.getEmpStatus();
            String ps = pension1.getPenStatus();
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

}
