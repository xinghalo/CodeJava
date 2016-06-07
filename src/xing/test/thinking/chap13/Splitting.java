package xing.test.thinking.chap13;

import java.util.Arrays;
/**
 * 根据指定的字符或者正则，分割字符串
 * 
 * @author xxh
 *
 */
public class Splitting {
	public static String knights = "Then, when you have found the shrubbery, you must cut down the mightiest tree in the forest... with... a herring";
	public static void split(String regex){
		System.out.println(Arrays.toString(knights.split(regex)));
	}
	public static void main(String[] args) {
		split(" ");
		split("\\W+");
		split("n\\W+");
	}
}
