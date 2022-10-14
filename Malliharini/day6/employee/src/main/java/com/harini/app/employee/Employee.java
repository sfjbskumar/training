package com.harini.app;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    int Empid;
    String Empname;
    float salary;
    String Department;

    public Employee(int Empid, String Empname, float salary, String Department)
    {
        this.Empid=Empid;
        this.Empname=Empname;
        this.salary=salary;
        this.Department=Department;
    }

    public String getEmpname() {
        return Empname;
    }
    public void setEmpname(String empname) {
        Empname = empname;
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
    public void setDepartment(String department) {
        Department = department;
    }
    public int getEmpid() {
        return Empid;
    }
    public void setEmpid(int empid) {
        Empid = empid;
    }
}
