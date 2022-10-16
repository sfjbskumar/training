package com.harini.app.employee.Controller;

import com.harini.app.employee.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    private Map<String, Employee> employeeMap= new HashMap<String,Employee>();

    @GetMapping("/get/employee")
    public Employee getEmployee(@RequestParam String Empname){
        Employee result= employeeMap.get(Empname);
        return result;
    }
    @PostMapping("save/employee")
    public void SaveEmployee(@RequestBody Employee employee){
        String Empname= employee.getEmpname();
        employeeMap.put(Empname,employee);
    }
    @PutMapping("update/employee")
    public Employee updateEmployee(@RequestParam String Empname,@RequestParam String Department){
        Employee result= employeeMap.get(Empname);
        result.setDepartment(Department);
        employeeMap.put(Empname,result);
        return result;

    }
    @DeleteMapping("remove/employee")
    public void deleteStudent(@RequestParam String Empname){
        employeeMap.remove(Empname);
    }
}
