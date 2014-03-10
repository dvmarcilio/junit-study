package study.chap3;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class StringReverserTest {

	@Test
	public void acceptsEmptyString() {
		String reverted = StringReverser.reverse(new String());
		assertEquals(reverted, new String());
	}

	@Test(expected = NullPointerException.class)
	public void throwsNullExceptionOnNullArgument() {
		StringReverser.reverse(null);
	}

	private static final Object[] getInputValues() {
		return $($("abcd", "dcba"), $("12345", "54321"));
	}

	@Test
	@Parameters(method = "getInputValues")
	public void revertsCorrectly(String s, String reverted) {
		assertEquals(reverted, StringReverser.reverse(s));
	}

}
