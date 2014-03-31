package study.chap4.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupsOfDigits {

	private static final String REGEX = "(\\d\\d\\d+)";

	public static Object find(String input) {
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(input);
		ResultFormatter result = new ResultFormatter();
		while (matcher.find())
			result.add(matcher.group());
		return result.getResult();
	}

	private static class ResultFormatter {

		private String result = "";
		private int added = 0;

		public void add(String group) {
			addSeparatorIfMoreThanOneGroup();
			result += group;
			added++;
		}

		private void addSeparatorIfMoreThanOneGroup() {
			if (added > 0)
				result += ", ";
		}

		public String getResult() {
			return result;
		}
	}

}
