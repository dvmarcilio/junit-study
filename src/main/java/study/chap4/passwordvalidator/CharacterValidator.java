package study.chap4.passwordvalidator;

public abstract class CharacterValidator {

	public boolean validate(Character character) {
		return validateChar(character);
	}

	protected abstract boolean validateChar(Character character);

}
