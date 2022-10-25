package com.pension.app.Controller;

import com.pension.app.model.Pension;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PensionController {
    private Map<String, Pension> pensionMap= new HashMap<String,Pension>();

  /*  @GetMapping("/get/studentapp")
    public Pension getStudent(@RequestParam String name){
        Pension result= pensionMap.get(name);
        return result;
    }*/
    @PostMapping("create/pension")
    public void SaveStudent(@RequestBody Pension pension){
        String name= pension.getApplicant_name();
        pensionMap.put(name,pension);
    }
    @PutMapping("edit/pension")
    public Pension updateStudent(@RequestParam String applicant_id,@RequestParam String applicant_name){
        Pension result= pensionMap.get(applicant_id);
        result.setApplicant_name(applicant_name);
        pensionMap.put(applicant_name,result);
        return result;

    }
 /*   @GetMapping("/get/all")
    public Map<String,Student> getStudent(){
        return studentMap;}

    @DeleteMapping("remove/studentapp")
    public void deleteStudent(@RequestParam String name){
        studentMap.remove(name);
    }
*/
}
