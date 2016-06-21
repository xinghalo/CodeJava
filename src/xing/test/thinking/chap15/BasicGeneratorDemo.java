package xing.test.thinking.chap15;

public class BasicGeneratorDemo {
	public static void main(String[] args) {
		Generator<CountedObject> create = BasicGenerator.create(CountedObject.class);
		for(int i=0; i<5; i++)
			System.out.println(create.next());
	}
}
