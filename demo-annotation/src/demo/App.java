package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {

		/*
		 * Person person = new Person(new NescafeCoffeeMaker()); person.prepareCoffee();
		 */

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		/* Person person = (Person) context.getBean("person"); */
		Person person = context.getBean("person", Person.class);
		person.prepareCoffee();

		Driver driver = context.getBean(Driver.class);
		driver.prepareCoffee();

	}

}
