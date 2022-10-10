package org.example;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    Greetings greetings;

    @Before
    public void setUp(){
        greetings= new Greetings();
    }

    @Test
    public void testSayThanks(){
        assertEquals("Thanks", greetings.sayThanks());
    }

    @Test
    public void testSayHi(){
        assertEquals("Hi", greetings.sayHi());
    }

    @Test
    public void testSayHello(){
        assertEquals("Hello", greetings.sayHello());
    }

    @Test
    public void testSayWelcome(){
        assertEquals("Welcome", greetings.sayWelcome());
    }

}
