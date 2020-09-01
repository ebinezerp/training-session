package demo;

import org.springframework.stereotype.Component;

@Component
public class BruCoffeeMaker implements CoffeeMaker {
	
	public void makeCoffee() {
		System.out.println("Bru Coffee maker made the coffee");
	}

}
