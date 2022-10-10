package org.example;
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Greeting greeting=new Greeting();
        String sr1 = greeting.sayHello();
        System.out.println(sr1);
        String sr2 = greeting.sayHi();
        System.out.println(sr2);
        String sr3 = greeting.sayWelcome();
        System.out.println(sr3);
        String sr4 =greeting.sayThanks();
        System.out.println(sr4);
    }
}
