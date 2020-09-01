package demo.firstdemo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NameValidatorTest {

	@Test
	public void test1() {
		NameValidator nameValidator = new NameValidator("abhishek");
		boolean actaul = nameValidator.isValid();
		assertTrue(actaul);
	}

}
