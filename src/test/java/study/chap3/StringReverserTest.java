package study.chap3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
	
	@Test
	public void revertsString() {
		String s = "abcd";
		String reverted = "dcba";
		assertEquals(reverted, StringReverser.reverse(s));
	}
	
	@Test
	public void revertsStringOfNumbers() {
		String s = "12345";
		String reverted = "54321";
		assertEquals(reverted, StringReverser.reverse(s));
	}

}
