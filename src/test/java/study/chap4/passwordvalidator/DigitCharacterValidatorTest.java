package study.chap4.passwordvalidator;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class DigitCharacterValidatorTest {
	
	private CharacterValidator charValidator;

	@Before
	public void setUp() {
		charValidator = new DigitCharacterValidator();
	}
	
	static final Object[] getLetterCharacters() {
		return $($('c'), $('a'), $(new Character('b')));
	}

	static final Object[] getDigitCharacters() {
		return $($('1'), $('5'), $(new Character('0')));
	}

	@Test
	@Parameters(method = "getLetterCharacters")
	public void shouldReturnFalseWhenCharIsLetter(Character letter) {
		assertEquals("Validate should return false when char is letter. ",
				false, charValidator.validate(letter));
	}

	@Test
	@Parameters(method = "getDigitCharacters")
	public void shouldReturnTrueWhenCharIsDigit(Character digit)
			throws Exception {
		assertEquals("Validate should return true when char is digit. ", true,
				charValidator.validate(digit));
	}
}
