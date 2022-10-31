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
    private String employee_status;

    @Column
    private String pension_status;

    @Column
    private String pension_money;

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


    public Pension(int id, int age, String name, int balance, int phone, String employee_status, String pension_status, String pension_money, int installment) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.balance = balance;
        this.phone = phone;
        this.employee_status = employee_status;
        this.pension_status = pension_status;
        this.pension_money = pension_money;
        this.installment = installment;
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


    public String getEmployee_status() {
        return employee_status;
    }

    public void setEmployee_status(String employee_status) {
        this.employee_status = employee_status;
    }

    public String getPension_status() {
        return pension_status;
    }

    public void setPension_status(String pension_status) {
        this.pension_status = pension_status;
    }

    public String getPension_money() {
        return pension_money;
    }

    public void setPension_money(String pension_money) {
        this.pension_money = pension_money;
    }

    public int getInstallment(){
        return installment;
    }
    public void setInstallment(int installment){
        this.installment=installment;
    }
}
