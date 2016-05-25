package xing.test.thinking.chap10;
/**
 * 嵌套类，static的内部类
 * 
 * 1 嵌套类对象并不需要外围的对象
 * 2 不能从嵌套类中访问其他的非静态外部类对象
 * 
 * @author xxh
 *
 */
public class Parcel11 {
	public static Contents contents(){
		return new ParcelContents();
	}
	private static class ParcelContents implements Contents{
		private int i = 11;
		public int value() {
			return i;
		}
	}
	
	public static Destination destination(String s){
		return new ParcelDestination(s);
	}
	private static class ParcelDestination implements Destination{
		private String label;
		public ParcelDestination(String whereTo) {
			label = whereTo;
		}
		public String readLabel() {
			return label;
		}
		public static void f(){}
		static int x = 10;
		static class AnotherLevel {
			public static void f(){
			}
			static int x = 10;
		}
	}
	public static void main(String[] args) {
		Contents c = contents();
		Destination d = destination("Tasmania");
		System.out.println(c.value());
		System.out.println(d.readLabel());
	}
}
