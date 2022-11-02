package com.kumar.demo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("groceryitmes")
public class Student
{
    //mark id as primary key
    @Id
//defining id as column name
   // @Column
    private int id;
    //defining name as column name
    //@Column
    private String name;
    //defining age as column name
    //@Column
    private int age;
    //defining email as column name
    //@Column
    private String email;
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
}
