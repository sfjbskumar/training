package SagarCalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyCalculator {
	public static void main(String[] args) {
		SpringApplication.run(MyCalculator.class, args);
	}
	public String addString(String a,String b){
		return a.concat(b);
	}

}
