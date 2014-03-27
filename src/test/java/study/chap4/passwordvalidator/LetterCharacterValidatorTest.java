package study.chap4.passwordvalidator;

import static org.junit.Assert.assertEquals;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class LetterCharacterValidatorTest {

	private CharacterValidator charValidator;

	@Before
	public void setUp() {
		charValidator = new LetterCharacterValidator();
	}

	static final Object[] getLetterCharacters() {
		return DigitCharacterValidatorTest.getLetterCharacters();
	}

	static final Object[] getDigitCharacters() {
		return DigitCharacterValidatorTest.getDigitCharacters();
	}

	@Test
	@Parameters(method = "getLetterCharacters")
	public void shouldReturnTrueWhenCharIsLetter(Character letter) {
		assertEquals("Validate should return true when char is letter. ", true,
				charValidator.validate(letter));
	}

	@Test
	@Parameters(method = "getDigitCharacters")
	public void shouldReturnFalseWhenCharIsDigit(Character digit)
			throws Exception {
		assertEquals("Validate should return false when char is digit. ",
				false, charValidator.validate(digit));
	}
}
