package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Driver {

	@Autowired
	@Qualifier("nescafeCoffeeMaker")
	private CoffeeMaker coffeeMaker;

	public void setCoffeeMaker(CoffeeMaker coffeeMaker) {
		this.coffeeMaker = coffeeMaker;
	}

	public void prepareCoffee() {
		coffeeMaker.makeCoffee();
	}

}
