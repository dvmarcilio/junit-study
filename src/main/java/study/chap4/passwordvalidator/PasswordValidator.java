package study.chap4.passwordvalidator;

public class PasswordValidator {

	private static String password;

	public static final String MUST_BE_LONGER_MESSAGE = "Password must have at least 6 characters";
	public static final String MUST_HAVE_DIGIT_MESSAGE = "Password must have at least one digit";

	public static boolean validate(String password) {
		setPassword(password);
		validateLength();
		validateDigit();
		return true;
	}

	private static void setPassword(String password) {
		PasswordValidator.password = password;
	}

	private static void validateLength() {
		if (password.length() < 6)
			throw new IllegalArgumentException(MUST_BE_LONGER_MESSAGE);
	}

	private static void validateDigit() {
		if (!passwordHasDigit())
			throw new IllegalArgumentException(MUST_HAVE_DIGIT_MESSAGE);
	}

	private static boolean passwordHasDigit() {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i)))
				return true;
		}
		return false;
	}
}
