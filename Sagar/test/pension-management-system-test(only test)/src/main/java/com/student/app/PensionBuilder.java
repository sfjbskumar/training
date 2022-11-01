package com.student.app;

public class PensionBuilder {
    private int id;
    private String name;
    private int age;
    private int bal;
    private String contact;
    private String empStatus;
    private String penStatus;
    private String lastPension;
    private int installment;

    public PensionBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public PensionBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PensionBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PensionBuilder setBal(int bal) {
        this.bal = bal;
        return this;
    }

    public PensionBuilder setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public PensionBuilder setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
        return this;
    }

    public PensionBuilder setPenStatus(String penStatus) {
        this.penStatus = penStatus;
        return this;
    }

    public PensionBuilder setLastPension(String lastPension) {
        this.lastPension = lastPension;
        return this;
    }

    public PensionBuilder setInstallment(int installment) {
        this.installment = installment;
        return this;
    }

    public Pension createPension() {
        return new Pension(id, name, age, bal, contact, empStatus, penStatus, lastPension, installment);
    }
}