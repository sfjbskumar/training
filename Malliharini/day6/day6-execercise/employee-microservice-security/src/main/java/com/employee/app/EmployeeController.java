package com.employee.app;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    private Map<String,Employee> employeeMap= new HashMap<String,Employee>();

    @GetMapping("/get/employee")
    public Employee getEmployee(@RequestParam String empname){
        Employee result= employeeMap.get(empname);
        return result;
    }
    @PostMapping("save/employee")
    public void SaveEmployee(@RequestBody Employee employee){
        String empname= employee.getEmpName();
        employeeMap.put(empname,employee);
    }
    @PutMapping("update/employee")
    public Employee updateEmployee(@RequestParam String empname,@RequestParam float salary){
        Employee result= employeeMap.get(empname);
        result.setSalary(salary);
        employeeMap.put(empname,result);
        return result;

    }
    @DeleteMapping("remove/employee")
    public void deleteEmployee(@RequestParam String empname){
       employeeMap.remove(empname);
    }
}
