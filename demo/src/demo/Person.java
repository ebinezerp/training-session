package demo;

public class Person {

	private CoffeeMaker coffeeMaker;

	/*
	 * public Person() { coffeeMaker = new ABCCoffeeMaker(); }
	 */

	public Person() {
	}

	public Person(CoffeeMaker coffeeMaker) {
		this.coffeeMaker = coffeeMaker;
	}

	/*
	 * public void setCoffeeMaker(CoffeeMaker coffeeMaker) { this.coffeeMaker =
	 * coffeeMaker; }
	 */

	public void prepareCoffee() {
		coffeeMaker.makeCoffee();
	}

}
