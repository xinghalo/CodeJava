package xing.test.thinking.chap14;

public class GenericToyTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Class<FancyToy> ftClass = FancyToy.class;
		FancyToy fancyToy = ftClass.newInstance();
		Class<? super FancyToy> up = ftClass.getSuperclass();
//		Class<Toy> up2 = ftClass.getSuperclass();
		Object obj = up.newInstance();
	}
}
