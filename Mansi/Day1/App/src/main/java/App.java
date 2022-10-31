import org.example2.Greeting;

public class App {
    public static void main(String[] args){
        System.out.println("Hello World!");
        Greeting greeting=new Greeting();
        System.out.println(greeting.sayHello());
        greeting.sayHi();
        System.out.println(greeting.sayWelcome());
        greeting.sayThanks();
    }
}
