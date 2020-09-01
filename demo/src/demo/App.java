package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		/*
		 * Person person = new Person(new NescafeCoffeeMaker()); person.prepareCoffee();
		 */

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Person person = (Person) context.getBean("person");
		person.prepareCoffee();

	}

}
