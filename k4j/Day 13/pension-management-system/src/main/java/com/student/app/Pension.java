package com.student.app;

import com.mysql.cj.protocol.a.NativeConstants;
import org.springframework.stereotype.Component;

@Component
public class Pension {
     int id;
     String name;
     String age;
     int balance_amount;
     int phone_no;
     String emp_status;
     String pension_status;
     String pension_mmyy;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public String getPension_mmyy() {
        return pension_mmyy;
    }

    public void setPension_mmyy(String pension_mmyy) {
        this.pension_mmyy = pension_mmyy;
    }

    public String getPension_status() {
        return pension_status;
    }

    public void setPension_status(String pension_status) {
        this.pension_status = pension_status;
    }

    public String getEmp_status() {
        return emp_status;
    }

    public void setEmp_status(String emp_status) {
        this.emp_status = emp_status;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public int getBalance_amount() {
        return balance_amount;
    }

    public void setBalance_amount(int balance_amount) {
        this.balance_amount = balance_amount;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pension(){

    }
    public Pension( int id,String name,String age, int balance_amount,int phone_no,String emp_status,String pension_status,String pension_mmyy) {
        this.id = id;
        this.name = name;
        this.age= age;
        this.balance_amount=balance_amount;
        this.phone_no=phone_no;
        this.emp_status=emp_status;
        this.pension_mmyy=pension_mmyy;
     }


}
