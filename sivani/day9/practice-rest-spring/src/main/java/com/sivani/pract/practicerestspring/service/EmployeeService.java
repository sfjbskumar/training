package com.sivani.pract.practicerestspring.service;

import com.sivani.pract.practicerestspring.models.Emp;
import com.sivani.pract.practicerestspring.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService{
    @Autowired(required = false)
    EmployeeRepository employeeRepository;

    public List<Emp> getAllEmployees(){
        List<Emp> employees = new ArrayList<Emp>();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));
        return employees;
    }

    public void saveOrUpdate(Emp employee)
    {
        employeeRepository.save(employee);
    }

}
