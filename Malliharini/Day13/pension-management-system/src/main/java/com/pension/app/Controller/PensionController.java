package com.pension.app.Controller;

import com.pension.app.Repository.PensionRepository;
import com.pension.app.Service.PensionService;
import com.pension.app.model.Pension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PensionController {
     @Autowired
    PensionService pensionService;
    PensionRepository pensionRepository;
   /* @PostMapping("create")
    public void SaveStudent(@RequestBody Pension pension){
        String name= pension.getApplicant_name();
        pensionMap.put(name,pension);
    }*/
    @PostMapping("/create")
    private String savePensionApplicant(@RequestBody Pension applicant)
    {
        pensionService.saveOrUpdate(applicant);
        return applicant.getApplicant_id();
    }
    /*@PutMapping("edit")
    public Pension updatePension(@RequestParam String applicant_id,@RequestParam String applicant_name){
        Pension result= pensionService.get(applicant_id);
        result.setApplicant_name(applicant_name);
        pensionService.put(applicant_name,result);
        return result;
    }*/
    @GetMapping("/checkstatus/{id}")
    private Pension getStudent(@PathVariable("id") int applicant_id)
    {
        return PensionService.getapplicantById(applicant_id);
    }
    @GetMapping("/checkBalance/{id}")
    private Pension checkbalance(@PathVariable("id") int applicant_id)
    {
        return PensionService.getapplicantById(applicant_id);
    }


}
