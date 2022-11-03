package com.pension.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="pension")
@Table(name="pension")
public class Pension {
    public Pension(int id, int age, String name, int balance, int phone, String empstatus, String penstatus, String penmmyy, int installment) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.balance = balance;
        this.phone = phone;
        this.empstatus = empstatus;
        this.penstatus = penstatus;
        this.penmmyy = penmmyy;
        this.installment = installment;
    }
    public Pension(){}


    @Id

    @Column
    private int id;

    @Column
    private int age;

    @Column
    private String name;

    @Column
    private int balance;

    @Column
    private int phone;

    @Column
    private String empstatus;

    @Column
    private String penstatus;

    @Column
    private String penmmyy;

    @Column
    private int installment;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getBalance(){
        return balance;
    }
    public void setBalance(int balance){
        this.balance=balance;
    }

    public int getPhone(){
        return phone;
    }
    public void setPhone(int phone){
        this.phone=phone;
    }

    public String getEmpstatus(){
        return empstatus;
    }
    public void setEmpstatus(String empstatus){
        this.empstatus=empstatus;
    }

    public String getPenstatus(){
        return penstatus;
    }
    public void setPenstatus(String penstatus){
        this.penstatus=penstatus;
    }

    public String  getPenmmyy(){
        return penmmyy;
    }
    public void setPenmmyy(String penmmyy){
        this.penmmyy=penmmyy;
    }

    public int getInstallment(){
        return installment;
    }
    public void setInstallment(int installment){
        this.installment=installment;
    }
}
