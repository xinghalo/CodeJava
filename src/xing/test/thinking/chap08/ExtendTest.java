package xing.test.thinking.chap08;
class A{
	public A() {
		System.out.println("A");
	}
}
class B extends A{
	public B() {
		System.out.println("B");
	}
}
class C extends B {
	private D d1 = new D("d1");
	private D d2 = new D("d2");
	public C() {
		System.out.println("C");
	}
}
class D {
	public D(String str) {
		System.out.println("D "+str);
	}
}
public class ExtendTest {
	public static void main(String[] args) {
		C c = new C();
	}
}
