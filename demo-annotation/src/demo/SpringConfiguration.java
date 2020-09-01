package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "demo")
public class SpringConfiguration {
	/*
	 * @Bean("bruCoffeeMaker") public BruCoffeeMaker getBruCoffeeMaker() { return
	 * new BruCoffeeMaker(); }
	 * 
	 * @Bean("nescafeCoffeMaker") public NescafeCoffeeMaker getNescafeCoffeeMaker()
	 * { return new NescafeCoffeeMaker(); }
	 * 
	 * 
	 * @Bean("person") public Person getPerson(BruCoffeeMaker bruCoffeeMaker) {
	 * return new Person(bruCoffeeMaker); }
	 * 
	 * 
	 * @Bean("person") public Person getPerson(NescafeCoffeeMaker
	 * nescafeCoffeeMaker) { return new Person(nescafeCoffeeMaker); }
	 */

}
