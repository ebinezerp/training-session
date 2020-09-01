package demo.firstdemo;

public class NameValidator {

	private String name;

	public NameValidator(String name) {
		super();
		this.name = name;
	}

	public boolean isValid() {
		/*
		 * char[] characters = name.toCharArray(); for (char character : characters) {
		 * if (!Character.isAlphabetic(character)) { return false; } } return true;
		 */

		return name.matches("[a-z]{4,}");
	}

}
