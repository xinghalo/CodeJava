package xing.test.thinking.chap19;

import java.util.Random;

class Enums {
	private static Random  rand = new Random(47);
	public static <T extends Enum<T>> T random(Class<T> ec){
		return random(ec.getEnumConstants());
	}
	public static <T> T random(T[] values){
		return values[rand.nextInt(values.length)];
	}
}
enum Activity {
	SITTING,LYING,STANDING,HOPPING,RUNNING,DODGING,JUMPING,FALLING,FLYING
}
public class RandomTest {
	public static void main(String[] args) {
		for(int i=0; i<20; i++){
			System.out.println(Enums.random(Activity.class) + "");
		} 
	}
}
