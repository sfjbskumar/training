package example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class GreetingTest {
    Greeting greeting;
    @Before
    public void setUp()
    {
        greeting = new Greeting();
    }
    @Test
    public void testHello(){
        assertEquals("Hello",greeting.sayHello());
    }
    @Test
    public void testWelcome(){
        assertEquals( "Welcome",greeting.sayWelcome());
    }
    @Test
    public void testHi(){
        assertEquals("Hi",greeting.sayHi());
    }
    @Test
    public void testThanks(){
        assertEquals( "Thanks",greeting.sayThanks());
    }
    }
