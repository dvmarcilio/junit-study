package study.chap3;

public class StringReverser {

	public static String reverse(String s) {
		String reversedString = new String();
		int lastIndex = s.length() - 1;
		for (int i = lastIndex; i >= 0; i--)
			reversedString += s.charAt(i);
		return reversedString;
	}

}
