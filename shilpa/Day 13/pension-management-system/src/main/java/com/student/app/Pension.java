package com.student.app;

import org.springframework.stereotype.Component;

public class Pension {
    private int id;
    private String name;
    private int age;
    private int phone;
    private int balanceAmount;
    private String empStatus;
    private String pensionStatus;
    private String pensionStarts;
    private int installments;

    public void setId(int id){this.id=id;}
    public int getId(){return id;}
    public void setName(String name){this.name=name;}
    public String getName(){return name;}
    public void setAge(int age){this.age=age;}
    public int getAge(){return age;}
    public void setPhone(int phone){this.phone=phone;}
    public int getPhone(){return phone;}
    public void setBalanceAmount(int balanceAmount){this.balanceAmount=balanceAmount;}
    public int getBalanceAmount(){return balanceAmount;}
    public void setEmpstatus(String empStatus){this.empStatus=empStatus;}
    public String getEmpStatus(){return empStatus;}
    public void setPensionstatus(String pensionStatus){this.pensionStatus=pensionStatus;}
    public String getPensionstatus(){return pensionStatus;}
    public void setPensionstarts(String pensionStarts){this.pensionStarts=pensionStarts;}
    public String getPensionstarts(){return pensionStarts;}
    public void setInstallments(int installments){this.installments=installments;}
    public int getInstallments(){return installments;}

}
