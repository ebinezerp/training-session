package demo;

import org.springframework.stereotype.Component;

@Component
public class NescafeCoffeeMaker implements CoffeeMaker{

	public void makeCoffee() {
		System.out.println("Nescafe Coffee maker made the coffee");
	}

}
