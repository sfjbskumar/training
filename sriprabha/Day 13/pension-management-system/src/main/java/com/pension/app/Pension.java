package com.pension.app;

//import org.springframework.stereotype.Component;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
//@Component
public class Pension {
    public Pension(int id, int age, String name, int balance, int phone, String empStatus, String pensionStatus, String pensionmmyy, int installment) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.balance = balance;
        this.phone = phone;
        this.empStatus = empStatus;
        this.pensionStatus = pensionStatus;
        this.pensionmmyy = pensionmmyy;
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
    private String empStatus;

    @Column
    private String pensionStatus;

    @Column
    private String pensionmmyy;

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

    public String getEmpStatus(){
        return empStatus;
    }
    public void setEmpStatus(String empStatus){
        this.empStatus=empStatus;
    }

    public String getPensionStatus(){
        return pensionStatus;
    }
    public void setPensionStatus(String pensionStatus){
        this.pensionStatus=pensionStatus;
    }

    public String  getPensionmmyy(){
        return pensionmmyy;
    }
    public void setPensionmmyy(String pensionmmyy){
        this.pensionmmyy=pensionmmyy;
    }

    public int getInstallment(){
        return installment;
    }
    public void setInstallment(int installment){
        this.installment=installment;
    }
}
