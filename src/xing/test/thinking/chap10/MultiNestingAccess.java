package xing.test.thinking.chap10;
/**
 * 内部类是可以无限层嵌套的
 * 
 * @author xxh
 */
class MNA {
	private void f(){}
	class A {
		private void g(){}
		public class B{
			void h(){
				System.out.println("123");
				g();
				f();
			}
		}
	}
}
public class MultiNestingAccess {
	public static void main(String[] args) {
		MNA mna = new MNA();
		MNA.A mnaa = mna.new A();
		MNA.A.B mnaab = mnaa.new B();
		mnaab.h();
	}
}