package org.example;
import example2.Greeting;

import java.util.ArrayList;

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
                ArrayList<String> l1 = new ArrayList<>(4);
                var a1 =greeting.sayHello();
                l1.add(a1);
                var a2 =greeting.sayHi();
                l1.add(a2);
                var a3=greeting.sayWelcome();
                l1.add(a3);
                var a4 =greeting.sayThanks();
                l1.add(a4);
                for(var i:l1){
                    System.out.println(i);
                }

    }
}
