package xing.test.thinking.chap14;

public class GenericClassReferences {
	public static void main(String[] args) {
		Class intClass = int.class;
		Class<Integer> genericIntClass = int.class;
		genericIntClass = Integer.class;
		intClass = double.class;
//		genericIntClass = double.class;
		
		Class<?> intClazz = int.class;
		intClazz = double.class;
		
		Class<? extends Number> bounded = int.class;
		bounded = double.class;
		bounded = Number.class;
	}
}
