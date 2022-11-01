//package org.example;
//
//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//
///**
// * Unit test for simple App.
// */
//public class AppTest
//    extends TestCase
//{
//    /**
//     * Create the test case
//     *
//     * @param testName name of the test case
//     */
//    public AppTest( String testName )
//    {
//        super( testName );
//    }
//
//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite()
//    {
//        return new TestSuite( AppTest.class );
//    }
//
//    /**
//     * Rigourous Test :-)
//     */
//    public void testApp()
//    {
//        assertTrue( true );
//    }
//}

package org.example;
import junit.framework.TestCase;
import junit.framework.TestSuite;
//import org.example2.Greeting;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Unit test for simple App.
 */
public class AppTest
{
    Greeting greeting;
    @Before
    public void setUp() {
        greeting = new Greeting();
    }
    @Test
    public void testHello() {
        String result = greeting.sayHello();
        assertEquals("Hello", result);
    }
    @Test
    public void testWelcome(){
        String result = greeting.sayWelcome();
        assertEquals("Welcome", greeting.sayWelcome());
    }
    @Test
    public void testHi(){
        String result = greeting.sayHi();
        assertEquals("Hi", greeting.sayHi());
    }
    @Test
    public void testThanks(){
        String result = greeting.sayThanks();
        assertEquals("Thanks", greeting.sayThanks());
    }
}

