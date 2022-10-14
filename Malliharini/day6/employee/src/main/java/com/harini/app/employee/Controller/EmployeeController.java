package com.harini.app.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    private Map<String,Employee> EmployeeMap= new HashMap<String,Employee>();

    @GetMapping("/get/app")
    public Employee getEmployee(@RequestParam String Empname){
        Employee result= EmployeeMap.get(Empname);
        return result;
    }
    @PostMapping("save/app")
    public void SaveEmployee(@RequestBody Employee employee){
        String Empname= EmployeeMap.getName();
        EmployeeMap.put(Empname,employee);
    }
    @PutMapping("update/app")
    public Employee updateEmployee(@RequestParam String Empname,@RequestParam String Department){
        Employee result= EmployeeMap.get(Empname);
        result.setDepartment(Department);
        EmployeeMap.put(Empname,result);
        return result;
    }
    @GetMapping("/get/all")
    public Map<String,Employee> getEmpname(){
        return EmployeeMap;}
    @DeleteMapping("remove/app")
    public void deleteEmployee(@RequestParam String Empname){
        EmployeeMap.remove(Empname);
    }
}