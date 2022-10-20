package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    Greetings greetings;

    @Before
    public void setUp() { greetings = new Greetings(); }

    @Test
    public void testHello(){
        assertEquals("Hello" , greetings.sayHello());
    }

    @Test
    public void testHii(){
        assertEquals("Hii" , greetings.sayHii());
    }

    @Test
    public void testWelcome(){
        assertEquals("Welcome" , greetings.sayWelcome());
    }

    @Test
    public void testThanks(){
        assertEquals("Thanks" , greetings.sayThanks());
    }
}
