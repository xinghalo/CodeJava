package xing.test.thinking.chap07;
class A{
	static{
		System.out.println("A static");
	}
}
class B extends A{
	static{
		System.out.println("B static");
	}
}
class C extends B{
	private static D d = new D();
	static{
		System.out.println("C static");
	}
}
class D{
	static{
		System.out.println("D static");
	}
}
public class ExtendTest {
	public static void main(String[] args) {
		C c = new C();
	}
}
