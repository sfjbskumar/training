package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Greetings greetings = new Greetings();
        System.out.println( "Hello World!" );
        String a = greetings.sayHi();
        System.out.println(a);
        String b = greetings.sayHello();
        System.out.println(b);
        String c = greetings.sayThanks();
        System.out.println(c);
        String d = greetings.sayWelcome();
        System.out.println(d);

    }
}
