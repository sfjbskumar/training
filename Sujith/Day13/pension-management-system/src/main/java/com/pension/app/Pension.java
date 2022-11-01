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
    private int phoneNo;

    @Column
    private String empStatus;
    @Column
    private String penApproval;
    @Column
    private String penMmYy;

    @Column
    private int balance;
    @Column
    private int installment;

    public Pension(){}

    public Pension(int id, int age, String name, int balance, int phoneNo, String empStatus, String penApproval, String penMmYy, int installment) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.balance = balance;
        this.phoneNo = phoneNo;
        this.empStatus = empStatus;
        this.penApproval = penApproval;
        this.penMmYy = penMmYy;
        this.installment = installment;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }



    public int getPhoneNo(){
        return phoneNo;
    }
    public void setPhoneNo(int phoneNo){
        this.phoneNo=phoneNo;
    }


    public String  getPenMmYy(){
        return penMmYy;
    }
    public void setPenMmYy(String penMmYy){
        this.penMmYy=penMmYy;
    }



    public String getEmpStatus(){
        return empStatus;
    }
    public void setEmpStatus(String empStatus){
        this.empStatus=empStatus;
    }

    public String getPenApproval(){
        return penApproval;
    }
    public void setPenApproval(String penApproval){
        this.penApproval=penApproval;
    }



    public int getBalance(){
        return balance;
    }
    public void setBalance(int balance){
        this.balance=balance;
    }

    public int getInstallment(){
        return installment;
    }
    public void setInstallment(int installment){
        this.installment=installment;
    }
}
