package study.chap4.passwordvalidator;

public class PasswordValidator {

	private static String password;
	
	public static final String SHORT_MESSAGE = "Password must have at least 6 characters";

	public static boolean validate(String password) {
		setPassword(password);
		validateLength();
		return true;
	}

	private static void setPassword(String password) {
		PasswordValidator.password = password;
	}

	private static void validateLength() {
		if(password.length() < 6)
			throw new IllegalArgumentException(SHORT_MESSAGE);
	}

}
