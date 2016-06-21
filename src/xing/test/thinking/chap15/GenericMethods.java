package xing.test.thinking.chap15;
/**
 * 如果想要使用泛型类，必须创建对象的时候指定类型参数的值
 * 
 * 如果使用泛型方法，不必指定泛型参数类型
 * 
 * @author xxh
 *
 */
public class GenericMethods {
	public <T> void f(T x){
		System.out.println(x.getClass().getSimpleName());
	}
	public static void main(String[] args) {
		GenericMethods genericMethods = new GenericMethods();
		genericMethods.f(" ");
		genericMethods.f(1);
		genericMethods.f(1.0);
		genericMethods.f(1.0F);
		genericMethods.f('c');
		genericMethods.f(genericMethods);
	}
}
