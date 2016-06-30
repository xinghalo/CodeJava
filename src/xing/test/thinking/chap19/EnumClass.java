package xing.test.thinking.chap19;
enum Shrubbery {
	GROUND,CRAWLING,HANGING
}
public class EnumClass {
	public static void main(String[] args) {
		for(Shrubbery s : Shrubbery.values()){
			System.out.println(s + " ordinal: "+s.ordinal());//ordinal()输出序号
			System.out.println(s.compareTo(Shrubbery.CRAWLING) + " ");//判断是否相等，返回证书
			System.out.println(s.equals(Shrubbery.CRAWLING));//判断是否相等
			System.out.println(s == Shrubbery.CRAWLING);//判断是否相等
			System.out.println(s.getDeclaringClass());//声明的类
			System.out.println(s.name());//获得名字
			System.out.println("------------------------");
		}
		for(String s : "HANGING CRAWLING GROUND".split(" ")){
			Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
			System.out.println(shrubbery);//可以通过字符串初始化
		}
	}
}
