package com.student.app;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity(name="pension")
@Table(name="pensiondetable")
public class Pension {
    @Id
    private int id;
    @Column
    private String name;


    @Column
    private int age;
    @Column
    private int bal;
    @Column
    private String contact;
    @Column
    private String empStatus;
    @Column
    private String penStatus;
    @Column
    private String lastPension;
    @Column
    private int installment;

    public Pension(int id, String name, int age, int balance, String mobile, String empStaus, String pensionStatus, String pensionMMYY, int installment) {
    }
    public Pension() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBal() {
        return bal;
    }

    public void setBal(int bal) {
        this.bal = bal;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public int getInstallment() {
        return installment;
    }

    public String getPenStatus() {
        return penStatus;
    }

    public void setPenStatus(String penStatus) {
        this.penStatus = penStatus;
    }

    public void setInstallment(int installment) {
        this.installment = installment;
    }

    public String getLastPension() {
        return lastPension;
    }

    public void setLastPension(String lastPension) {
        this.lastPension = lastPension;
    }
}
