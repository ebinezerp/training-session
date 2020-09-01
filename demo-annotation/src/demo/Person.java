package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

	@Autowired
	@Qualifier("bruCoffeeMaker")
	private CoffeeMaker coffeeMaker;

	/*
	 * public Person() { coffeeMaker = new ABCCoffeeMaker(); }
	 */

	public Person() {
	}

	public Person(CoffeeMaker coffeeMaker) {
		this.coffeeMaker = coffeeMaker;
	}

	public void setCoffeeMaker(CoffeeMaker coffeeMaker) {
		this.coffeeMaker = coffeeMaker;
	}

	public void prepareCoffee() {
		coffeeMaker.makeCoffee();
	}

}
