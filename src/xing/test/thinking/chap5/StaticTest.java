package xing.test.thinking.chap5;
class A{
	public A() {
		System.out.println("A constructor");
	}
}

class VarTest{
	static A a = new A();
	public static int b = 0;
	public int c = 0;
	static{
		System.out.println("VarTest static");
	}
	public VarTest() {
		System.out.println("VarTest constructor");
	}
	public static void test(){
		System.out.println("in static test func");
	}
}
public class StaticTest {
	public static void main(String[] args) {
		System.out.println("start testing!");
		System.out.println("如果不new VarTest或者使用VarTest的静态内容，就不会触发VarTest静态块的执行");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		VarTest.test();//也会触发静态块的执行
		
		VarTest testa = new VarTest();
		VarTest testb = new VarTest();
		System.out.println("testa.b: "+testa.b);
		System.out.println("testb.b: "+testb.b);
		System.out.println("testa.c: "+testa.c);
		System.out.println("testb.c: "+testb.c);
		//如果修改b属性的值，所有对象的内容都会改变
		testa.b = 3;
		System.out.println("testa.b: "+testa.b);
		System.out.println("testb.b: "+testb.b);
	}
}
