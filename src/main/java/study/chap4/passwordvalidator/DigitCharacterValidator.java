package study.chap4.passwordvalidator;

public class DigitCharacterValidator extends CharacterValidator {

	@Override
	protected boolean validateChar(Character character) {
		return Character.isDigit(character);
	}

}
