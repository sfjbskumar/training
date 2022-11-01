package com.pension.app.controller;


//import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pension.app.model.Pension;
import com.pension.app.service.PensionService;
//creating RestController
@RestController
public class PensionController {

    private Map<String, Pension> pensionMap= new HashMap<String,Pension>();
    //autowired the PensionService class
    @Autowired
    PensionService pensionService;
    //creating a get mapping that retrieves all the students detail from the database
    /*
    @GetMapping("/pension")
    private List<Pension> getAllPension()
    {
        return pensionService.getAllPension();
    }
    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/pension/{id}")
    private Pension getPension(@PathVariable("id") int id)
    {
        return pensionService.getPensionById(id);
    }
    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/pension/{id}")
    private void deletePension(@PathVariable("id") int id)
    {
        pensionService.delete(id);
    }*/
    //creating post mapping that post the student detail in the database
    @PostMapping("/pension")
    private int savePension(@RequestBody Pension pension)
    {
        pensionService.saveOrUpdate(pension);
        return pension.getId();
    }
    @PutMapping("update/pension")
    public Pension updatePension(@RequestParam int id,@RequestParam String name){
        Pension result= pensionMap.get(id);
        result.setName(name);
        pensionMap.put(name,result);
        return result;
}
}