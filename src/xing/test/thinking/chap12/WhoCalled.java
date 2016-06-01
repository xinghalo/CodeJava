package xing.test.thinking.chap12;
/**
 * 测试轨迹栈
 * @author xxh
 */
public class WhoCalled {
	static void f(){
		try{
			throw new Exception();
		}catch(Exception e){
			for(StackTraceElement ste : e.getStackTrace()){
				System.out.println(ste.getClassName());
				System.out.println(ste.getMethodName());
				System.out.println(ste.getFileName());
				System.out.println(ste.getLineNumber());
			}
		}
	}
	static void g(){
		f();
	}
	static void h(){
		g();
	}
	public static void main(String[] args) {
		f();
		System.out.println("--------------------------------------");
		g();
		System.out.println("--------------------------------------");
		h();
		System.out.println("---------------------------------------");
	}
}
