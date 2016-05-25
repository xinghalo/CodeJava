package xing.test.thinking.chap10;
/**
 * 这么搞无法直接运行，需要经过编译，然后运行它的ClassInInterface$Test
 * 
 * @author xxh
 *
 */
public interface ClassInInterface {
	void howdy();
	class Test implements ClassInInterface{
		@Override
		public void howdy() {
			System.out.println("Howdy");
		}
		public static void main(String[] args) {
			new Test().howdy();
		}
	}
}
