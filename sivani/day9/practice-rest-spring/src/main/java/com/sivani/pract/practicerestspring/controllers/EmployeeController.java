package com.sivani.pract.practicerestspring.controllers;

import com.sivani.pract.practicerestspring.models.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sivani.pract.practicerestspring.service.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping("/save/employee")
    public String saveEmployee(@RequestBody Emp employee){
        employeeService.saveOrUpdate(employee);
        return employee.getEmpId();
    }

    //fetch all employees
    @GetMapping("/get/employees")
    public List<Emp> getEmployees(){
        return employeeService.getAllEmployees();
    }

    //fetch single employee with empId
   /* @GetMapping("/getEmp")
    public Employee getEmp(@RequestParam(name="empId", required = true) String empId){
        Employee e = empMap.get(empId);
        return e;
    }

    @DeleteMapping("/removeEmp")
    public String removeEmployee(@RequestParam(name = "empId", required = true) String empId){
        empMap.remove(empId);
        return "Employee details with empId:"+empId+" deleted successfully!";
    }

    @PutMapping("/updateEmp")
    public String updateEmployee(@RequestParam(name="empId", required = true) String empId,
                                   @RequestParam(name="empName", required = false) String empName,
                                   @RequestParam(name="role", required = false) String role){
        Employee e = empMap.get(empId);
        if(empName!=null){
            e.setEmpName(empName);
        }
        if(role!=null){
            e.setRole(role);
        }
        empMap.put(empId, e);
        return "Updated Successfully!";
    }
*/

}
