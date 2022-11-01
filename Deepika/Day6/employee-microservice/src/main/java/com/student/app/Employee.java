package com.student.app;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    String EmpID;
    String Empname;
    String department;

    int salary;

    public Employee(String empID, String empname, String department, int salary) {
        EmpID = empID;
        Empname = empname;
        this.department = department;
        this.salary = salary;
    }

    public Employee(){

    }


    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID(String empID) {
        this.EmpID = empID;
    }

    public String getEmpname() {
        return Empname;
    }

    public void setEmpname(String empname) {
        this.Empname = empname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
