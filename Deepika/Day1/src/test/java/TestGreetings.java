import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGreetings {
    Greetings greetings;
    @Before
    public void setup(){
        greetings=new Greetings();
    }
    @Test
    public void testHello(){
        assertEquals("Hello",greetings.sayHello());
    }
    @Test
    public void testHi(){
        assertEquals("Hi",greetings.sayHi());
    }
    @Test
    public void testWelcome(){
        assertEquals("Welcome",greetings.sayWelcome());
    }
    @Test
    public void testThanks(){
        assertEquals("Thanks",greetings.sayThanks());
    }


}
