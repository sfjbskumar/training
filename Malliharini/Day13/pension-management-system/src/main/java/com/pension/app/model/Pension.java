package com.pension.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//marking class as an entity
@Entity
//define class name as table name
@Table
public class Pension {
    //primary key
    @Id
//defining id as column name
    @Column
    private int applicant_id;
    @Column
    private String applicant_name;
    @Column
    private String age;
    @Column
    private int balance_amount;
    @Column
    private int contact_no;
    @Column
    private  String emp_status;
    @Column
    private String pension_status;
    @Column
    private String last_pension_issue;
    @Column
    private int installment;

    public int getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(int applicant_id) {
        this.applicant_id = applicant_id;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getBalance_amount() {
        return balance_amount;
    }

    public void setBalance_amount(int balance_amount) {
        this.balance_amount = balance_amount;
    }

    public int getContact_no() {
        return contact_no;
    }

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmp_status() {
        return emp_status;
    }

    public void setEmp_status(String emp_status) {
        this.emp_status = emp_status;
    }

    public String getPension_status() {
        return pension_status;
    }

    public void setPension_status(String pension_status) {
        this.pension_status = pension_status;
    }

    public String getLast_pension_issue() {
        return last_pension_issue;
    }

    public void setLast_pension_issue(String last_pension_issue) {
        this.last_pension_issue = last_pension_issue;
    }

    public int getInstallment() {
        return installment;
    }

    public void setInstallment(int installment) {
        this.installment = installment;
    }
}
