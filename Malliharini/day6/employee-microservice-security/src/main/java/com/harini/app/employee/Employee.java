package com.harini.app.employee;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    String Empname;
    String Empid;
    float salary;
    String Department;

    public Employee(String Empid, String Empname, float salary, String Department)
    {
        this.Empid=Empid;
        this.Empname=Empname;
        this.salary=salary;
        this.Department=Department;
    }

    public String getEmpname() {
        return Empname;
    }
    public void setEmpname(String Empname) {
        Empname = Empname;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String Department) {
        Department = Department;
    }
    public String getEmpid() {
        return Empid;
    }
    public void setEmpid(String Empid) {
        Empid = Empid;
    }
}
