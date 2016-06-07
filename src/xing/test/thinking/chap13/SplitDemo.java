package xing.test.thinking.chap13;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SplitDemo {
	public static void main(String[] args) {
		String input = "This!!unusal use!!of exclamation!!points";
		System.out.println(Arrays.toString(Pattern.compile("!!").split(input)));
		System.out.println(Arrays.toString(Pattern.compile("!!").split(input,3)));		
	}
}
