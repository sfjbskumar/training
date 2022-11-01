package org.example;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Greeting greeting=new Greeting();
        ArrayList<String> l1 = new ArrayList<>(4);

        var a1 = greeting.sayHello();
        l1.add(a1);
//        System.out.println(a1);
        var b1 = greeting.sayHi();
        l1.add(b1);
//        System.out.println(b1);
        var c1 = greeting.sayWelcome();
        l1.add(c1);
//        System.out.println(c1);
        var d1 = greeting.sayThanks();
        l1.add(d1);
//        System.out.println(d1);

        for(var i:l1)
        {
            System.out.println(i);
        }

    }
}
