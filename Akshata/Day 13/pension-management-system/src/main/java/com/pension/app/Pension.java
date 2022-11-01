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
    int id;
    @Column
    String name;
    @Column
    String age;
    @Column
    int mobile;
    @Column
    int balamt;
    @Column
    String estatus;
    @Column
    String pstatus;
    @Column
    String pmonth;
    @Column
    int installment;


    public Pension(int id, String name, String age, int mobile, int balamt, String estatus, String pstatus, String pmonth,int installment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile=mobile;
        this.balamt=balamt;
        this.estatus=estatus;
        this.pstatus=pstatus;
        this.pmonth=pmonth;
        this.installment=installment;

    }
    public Pension(){

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getBalamt() {
        return balamt;
    }

    public void setBalamt(int balamt) {
        this.balamt = balamt;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    public String getPmonth() {
        return pmonth;
    }

    public void setPmonth(String pmonth) {
        this.pmonth = pmonth;
    }

    public int getInstallment() {
        return installment;
    }

    public void setInstallment(int installment) {
        this.installment = installment;
    }



}
