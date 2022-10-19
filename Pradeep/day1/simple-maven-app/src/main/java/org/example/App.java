package org.example;
import org.example2.Greeting;

/**
 * Hello world!
 *
 */
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
