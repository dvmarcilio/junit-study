package study.chap4.passwordvalidator;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	@Parameters(method = "shortPasswords")
	public void passwordShouldHaveAtLeastSixCharacters(String shortPassword) {
		expectIllegalArgExcWithMessage(PasswordValidator.MUST_BE_LONGER_MESSAGE);
		PasswordValidator.validate(shortPassword);
	}

	static final Object[] shortPasswords() {
		return $($("12345"), $("1234"), $("123"), $("12"), $("1"), $(""));
	}

	private void expectIllegalArgExcWithMessage(String message) {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(message);
	}

	@Test
	@Parameters(method = "validPasswords")
	public void validatesValidPassword(String validPassword) throws Exception {
		assertTrue(PasswordValidator.validate(validPassword));
	}

	static final Object[] validPasswords() {
		return $($("a23456"), $("1bcdef"), $("abcde12345"), $("1 a   "));
	}

	@Test
	@Parameters(method = "noDigitPasswords")
	public void passwordShouldHaveAtLeastOneDigit(String passwordWithNoDigit)
			throws Exception {
		expectIllegalArgExcWithMessage(PasswordValidator.MUST_HAVE_DIGIT_MESSAGE);
		PasswordValidator.validate(passwordWithNoDigit);
	}
	
	static final Object[] noDigitPasswords() {
		return $($("abcdef"), $("ABCDEF"), $("qwerty"));
	}
	
	@Test
	@Parameters(method = "noLetterPasswords")
	public void passwordShouldHaveAtLeastOneLetter(String passwordWithNoLetter) throws Exception {
		expectIllegalArgExcWithMessage(PasswordValidator.MUST_HAVE_LETTER_MESSAGE);
		PasswordValidator.validate(passwordWithNoLetter);
	}
	
	static final Object[] noLetterPasswords() {
		return $($("123456"), $("654321"), $("1 &%$#@!()"));
	}

}
