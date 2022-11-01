package com.student.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Pension {
    @Id
    @Column

    int id;
    @Column
    String pensinorName;
    @Column
    int pensinorAge;
    @Column
    int balance;
    @Column
    long phoneNo;
    @Column
    String employmentStatus;
    @Column
    String pensionStatus;
    @Column
    String pensionmmyy;
    @Column
    int installment;

    public Pension(){}

    public Pension(int id, String pensinorName, int pensinorAge, int balance, long phoneNo, String employmentStatus, String pensionStatus, String pensionmmyy, int installment) {
        this.id = id;
        this.pensinorName = pensinorName;
        this.pensinorAge = pensinorAge;
        this.balance = balance;
        this.phoneNo = phoneNo;
        this.employmentStatus = employmentStatus;
        this.pensionStatus = pensionStatus;
        this.pensionmmyy = pensionmmyy;
        this.installment = installment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPensinorName() {
        return pensinorName;
    }

    public void setPensinorName(String pensinorName) {
        this.pensinorName = pensinorName;
    }

    public int getPensinorAge() {
        return pensinorAge;
    }

    public void setPensinorAge(int pensinorAge) {
        this.pensinorAge = pensinorAge;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getPensionStatus() {
        return pensionStatus;
    }

    public void setPensionStatus(String pensionStatus) {
        this.pensionStatus = pensionStatus;
    }

    public String getPensionmmyy() {
        return pensionmmyy;
    }

    public void setPensionmmyy(String pensionmmyy) {
        this.pensionmmyy = pensionmmyy;
    }

    public int getInstallment() {
        return installment;
    }

    public void setInstallment(int installment) {
        this.installment = installment;
    }
}
