package com.employee.app;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    private Map<String,Employee> employeeMap= new HashMap<String,Employee>();

    @GetMapping("/get/employee")
    public Employee getEmployee(@RequestParam String name){
        Employee result= employeeMap.get(name);
        return result;
    }
    @PostMapping("save/employee")
    public void SaveStudent(@RequestBody Student student){
        String name= student.getName();
        studentMap.put(name,student);
    }
    @PutMapping("update/employee")
    public Student updateStudent(@RequestParam String name,@RequestParam String std){
        Student result= studentMap.get(name);
        result.setStd(std);
        studentMap.put(name,result);
        return result;

    }
    @DeleteMapping("remove/employee")
    public void deleteStudent(@RequestParam String name){
        studentMap.remove(name);
    }
}
