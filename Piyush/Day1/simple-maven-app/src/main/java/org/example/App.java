package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Greeting greeting= new Greeting();
        String x= greeting.sayHello();
        String y= greeting.sayWelcome();
        String z= greeting.sayHi();
        String w= greeting.sayThanks();
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(w);
        System.out.println( "Hello World!" );
    }
}
