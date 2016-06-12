package xing.test.thinking.chap14;

import java.util.Random;

class Initable {
	static final int staticFinal = 47;
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
	static {
		System.out.println("Initialization Initable");
	}
}
class Initable2 {
	static int staticNonFinal = 147;
	static {
		System.out.println("Initialization Initable2");
	}
}
class Initable3 {
	static int staticNonFinal = 74;
	static {
		System.out.println("Initialization Initable3");
	}
}
public class ClassInitialization {
	public static Random rand = new Random(47);
	public static void main(String[] args) {
		Class initable = Initable.class;//仅适用class并不会触发初始化
		System.out.println("After creating Initable ref");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);
		System.out.println(Initable2.staticNonFinal);
		Class initable3 = null;//适用forName可以立刻触发初始化
		try {
			initable3 = Class.forName("xing.test.thinking.chap14.Initable3");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("After creating Initables ref");
		System.out.println(Initable3.staticNonFinal);
	}
}
