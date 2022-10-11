package org.example;


import org.example2.Greeting;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GreetingTest {
    Greeting greeting;
    @Before
    public void setUp(){
        greeting = new Greeting();
    }
    @Test
    public void testHello()
    {
        String result = greeting.sayHello();
        assertEquals("Hello",result);
        System.out.println("say hello");
    }
    @Test
    public void testWelcome()
    {
        String result = greeting.sayWelcome();
        assertEquals("Welcome",result);
        System.out.println("welcome mama");
    }
    @Test
    public void testHi()
    {
        String result = greeting.sayHi();
        assertEquals("Hi",result);
    }
    @Test
    public void testThanks()
    {
        String result = greeting.sayThanks();
        assertEquals("Thanks",result);
        System.out.println("TEST CASES PASSED");
    }



}