package study.chap4.passwordvalidator;

public class PasswordValidator {

	private static String password;

	public static final Integer MINIMUM_LENGTH = 6;

	public static final String MUST_BE_LONGER_MESSAGE = "Password must have at least + "
			+ MINIMUM_LENGTH + " characters";
	public static final String MUST_HAVE_DIGIT_MESSAGE = "Password must have at least one digit";
	public static final String MUST_HAVE_LETTER_MESSAGE = "Password must have at least one letter";

	public static boolean validate(String password) {
		setPassword(password);
		validateLength();
		validateDigit();
		validateLetter();
		return true;
	}

	private static void setPassword(String password) {
		PasswordValidator.password = password;
	}

	private static void validateLength() {
		if (password.length() < MINIMUM_LENGTH)
			throw new IllegalArgumentException(MUST_BE_LONGER_MESSAGE);
	}

	private static void validateDigit() {
		if (!passwordHasDigit())
			throw new IllegalArgumentException(MUST_HAVE_DIGIT_MESSAGE);
	}

	private static boolean passwordHasDigit() {
		return validatePasswordThroughCharValidator(new DigitCharacterValidator());
	}

	private static boolean validatePasswordThroughCharValidator(
			CharacterValidator charValidator) {
		for (int i = 0; i < password.length(); i++) {
			if (charValidator.validate(password.charAt(i)))
				return true;
		}
		return false;
	}

	private static void validateLetter() {
		if (!passwordHasLetter())
			throw new IllegalArgumentException(MUST_HAVE_LETTER_MESSAGE);
	}

	private static boolean passwordHasLetter() {
		return validatePasswordThroughCharValidator(new LetterCharacterValidator());
	}

}
