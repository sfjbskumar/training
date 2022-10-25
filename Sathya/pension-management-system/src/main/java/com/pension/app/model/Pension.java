package com.pension.app.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//mark class as an Entity
//defining class name as Table name
@Entity
@Table
public abstract class Pension
{

    //mark id as primary key
    @Id
//defining id as column name
    @Column
    private int id;
    //defining name as column name
    @Column
    private String name;
    //defining age as column name
    @Column
    private int age;
    //defining email as column name
    @Column
    private int balance_amount;

    @Column
    private int phone_number;

    @Column
    private String employee_status;

    @Column
    private String pension_status;

    @Column
    private String pension_mmyy;

    @Column
    private int installment;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getBalance_amount ()
    {
        return balance_amount;
    }
    public void setBalance_amount(int balance_amount)
    {
        this.balance_amount= balance_amount;
    }
    public int getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(int phone_number) {
        this.phone_number =phone_number;
    }
    public String getEmployee_status() {
        return employee_status;
    }
    public void setEmployee_status(String employee_status) {
        this.employee_status=employee_status;
    }
    public String getPension_status() {
        return pension_status;
    }
    public void setPension_status(String pension_status) {
        this.pension_status =pension_status;
    }
    public String getPension_mmyy() {
        return pension_mmyy;
    }
    public void setPension_mmyy(String pension_mmyy) {
        this.pension_mmyy=pension_mmyy;
    }
    public int getInstallment() {
        return installment;
    }
    public void setInstallment(int installment) {
        this.installment =installment;
    }
}
