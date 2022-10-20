package com.kumar.demo.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import javax.persistence.Id;



//mark class as an Entity

//defining class name as Table name
@Document("groceryitems")
public class Student
{
    //mark id as primary key
    @Id
//defining id as column name

    private int id;
    //defining name as column name

    private String name;
    //defining age as column name

    private int age;
    //defining email as column name

    private String email;
    //defining salary as column name

    private int salary;
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
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public int getSalary(){return salary;}
    public void setSalary(int salary){this.salary=salary;}
}
