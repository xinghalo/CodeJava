package xing.test.thinking.chap13;

public class Replacing {
	private static String s = Splitting.knights;
	public static void main(String[] args) {
		System.out.println(s.replaceFirst("f\\w+", "测试"));
		System.out.println(s.replaceAll("shrubbery|tree|herring", "测试"));
	}
}
