package org.example;

import src.test.java.org.example.Greeting;
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Greeting greeting=new Greeting();
        greeting.sayHello();
        greeting.sayHi();
        greeting.sayWelcome();
        greeting.sayThanks();
    }
}
