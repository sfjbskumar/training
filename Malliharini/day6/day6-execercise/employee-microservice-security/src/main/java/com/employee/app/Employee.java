package com.employee.app;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    int empid;
    String empname;
    float salary;
    String department;

    public Employee(int empid,String empname,float salary,String department) {
        this.empid = empid;
        this.empname =empname;
        this.salary = salary;
        this.department = department;
    }
    public Employee(){

    }
    public int getEmpId() {
        return empid;
    }

    public void setEmpId(String empid) {
        this.empname = empname;
    }

    public String getEmpName() {
        return empname;
    }

    public void setEmpName(String empname) {
        this.empname = empname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
