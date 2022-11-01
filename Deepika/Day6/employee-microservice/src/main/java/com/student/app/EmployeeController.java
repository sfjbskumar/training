package com.student.app;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    private Map<String,Employee> employeeMap = new HashMap<String,Student>();

    @GetMapping("/get/student")
    public Employee getEmployee(@RequestParam String name){
        Employee result= employeeMap.get(name);
        return result;
    }
    @PostMapping("save/employee")
    public void SaveEmployee(@RequestBody Employee employee){
        String name= employee.getName();
        employeeMap.put(name,employee);
    }
    @PutMapping("update/student")
    public Student updateEmployee(@RequestParam String name,@RequestParam String std){
        Employee result= employeeMap.get(name);
        result.setStd(std);
        employeeMap.put(name,result);
        return result;

    }
    @DeleteMapping("remove/student")
    public void deleteEmployee(@RequestParam String name){
        employeeMap.remove(name);
    }
}
