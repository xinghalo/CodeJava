package xing.test.jdk;
class A{
	@Override
	public String toString() {
		return "A";
	}
}
class B extends A{
	@Override
	public String toString() {
		return "B";
	}
}
class C {
	@Override
	public String toString() {
		return "C";
	}
}
public class ClassAsSubClassTest {
	public static void main(String[] args) {
		System.out.println(B.class.asSubclass(A.class));
		System.out.println(C.class.asSubclass(A.class));
	}
}
