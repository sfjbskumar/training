package org.example;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GreetingTest
    {
        Greeting greeting;
        @Before
        public  void  setUp(){greeting=new Greeting();}
        @Test
        public  void testHello()
        {
            String result=greeting.sayHello();
            assertEquals("Hello",result);
        }

        @Test
        public  void testWelcome() {
            String result = greeting.sayWelcome();
            assertEquals("Welcome", greeting.sayWelcome());
        }

        @Test
        public  void testHi(){
            String result=greeting.sayHi();
            assertEquals("Hi",greeting.sayHi());
        }
        @Test
        public  void testThanks(){
            String result=greeting.sayThanks();
            assertEquals("Thanks",result);
        }
    }


