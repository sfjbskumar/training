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
