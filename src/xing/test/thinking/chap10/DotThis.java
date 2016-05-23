package xing.test.thinking.chap10;

public class DotThis {
	void f(){
		System.out.println("DotThis.f()");
	}
	public class Inner{
		public DotThis outer(){
			return DotThis.this;//获得外部对象的引用
		}
	}
	public Inner inner(){
		return new Inner();
	}
	public static void main(String[] args) {
		DotThis dotThis = new DotThis();
		DotThis.Inner inner = dotThis.inner();
		inner.outer().f();//通过Inner对象的outer方法，获得外部的引用
	}
}
