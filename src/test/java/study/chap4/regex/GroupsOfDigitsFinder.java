package study.chap4.regex;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class GroupsOfDigitsFinder {

	@Test
	@Parameters(method = "inputValues")
	public void shouldReturnGroupsOfDigitsFoundOnString(String input,
			String output) throws Exception {
		assertEquals(output , GroupsOfDigits.find(input));
	}

	static final Object[] inputValues() {
		return $($("abc 12", ""), $("cdefg 345 12bb23", "345"),
				$("cdefg 345 12bbb33 678tt", "345, 678"));
	}

}
