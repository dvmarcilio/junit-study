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
	public ExpectedException illegalArgExc = ExpectedException.none();

	static final Object[] shortPasswords() {
		return $($("12345"), $("1234"), $("123"), $("12"), $("1"), $(""));
	}

	@Test
	@Parameters(method = "shortPasswords")
	public void passwordWithLessThan6CharsShouldThrowIllegalArgExc(String password) {
		expectIllegalArgExcWithMessage(PasswordValidator.SHORT_MESSAGE);
		PasswordValidator.validate(password);
	}
	
	private void expectIllegalArgExcWithMessage(String message) {
		illegalArgExc.expect(IllegalArgumentException.class);
		illegalArgExc.expectMessage(message);
	}

}
