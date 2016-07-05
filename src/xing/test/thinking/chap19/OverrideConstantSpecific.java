package xing.test.thinking.chap19;
/**
 * f()为默认方法，再enum中可以进行覆盖
 * 
 * @author xxh
 */
public enum OverrideConstantSpecific {
	NUT,BOLT,WASHER {
		void f() {
			System.out.println("Overriden method");
		}
	};
	void f(){
		System.out.println("default behavior");
	}
	public static void main(String[] args) {
		for(OverrideConstantSpecific ocs : values()){
			System.out.println(ocs + ":");
			ocs.f();
		}
	}
}
