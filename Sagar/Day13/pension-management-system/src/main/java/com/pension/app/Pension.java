package com.pension.app;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Pension {

    @Id
    @Column
        private int id;
    @Column
        private String name;
    @Column
        private int age;
    @Column
        private int bal;
    @Column
        private int contact;
    @Column
        private String empStatus;
    @Column
        private String penStatus;
    @Column
        private String lastPension;
    @Column
        private int installment;


    public Pension(int id, String name, int age, int bal, int contact, String empStatus, String penStatus, String lastPension, int installment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bal = bal;
        this.contact = contact;
        this.empStatus = empStatus;
        this.penStatus = penStatus;
        this.lastPension = lastPension;
        this.installment = installment;
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

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public String getPenStatus() {
        return penStatus;
    }

    public void setPenStatus(String penStatus) {
        this.penStatus = penStatus;
    }

    public String getLastPension() {
        return lastPension;
    }

    public void setLastPension(String lastPension) {
        this.lastPension = lastPension;
    }

    public int getInstallment() {
        return installment;
    }

    public void setInstallment(int installment) {
        this.installment = installment;
    }


    public void addEmployee(Pension pension) {
    }


}

