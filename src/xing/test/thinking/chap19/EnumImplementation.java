package xing.test.thinking.chap19;

import java.util.Random;

import xing.test.thinking.chap15.Generator;
/**
 * 枚举 也可以 实现继承
 * 
 * @author xxh
 */
enum CartoonCharacter implements Generator<CartoonCharacter>{
	SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
	private Random rand = new Random(47);
	@Override
	public CartoonCharacter next() {
		return values()[rand.nextInt(CartoonCharacter.values().length)];
	}
}
public class EnumImplementation {
	public static <T> void printNext(Generator<T> rg){
		System.out.println(rg.next() + ", ");
	}
	public static void main(String[] args) {
		CartoonCharacter cc = CartoonCharacter.BOB;
		for(int i=0; i<10; i++){
			printNext(cc);
		}
	}
}
