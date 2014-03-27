package study.chap4.passwordvalidator;

public class LetterCharacterValidator extends CharacterValidator {

	@Override
	protected boolean validateChar(Character character) {
		return Character.isLetter(character);
	}

}
