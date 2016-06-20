package xing.test.thinking.chap15;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>,Iterator<Coffee>{
	private Class[] types = {Latte.class,Mocha.class,Cappuccino.class,Americano.class,Breve.class};
	private static Random rand = new Random(47);
	
	public CoffeeGenerator() {}
	
	private int size = 0;
	
	public CoffeeGenerator(int sz){
		size = sz;
	}
	@Override
	public Coffee next(){
		try{
			return (Coffee)types[rand.nextInt(types.length)].newInstance();
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
	/*class CoffeeIterator implements Iterator<Coffee>{
		int count = size;
		public boolean hasNext(){
			return count > 0;
		}
		public Coffee next(){
			count--;
			return CoffeeGenerator.this.next();
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	public Iterator<Coffee> iterator(){
		return new CoffeeIterator();
	}*/
	public static void main(String[] args) {
		System.out.println("````````````````");
		CoffeeGenerator gen = new CoffeeGenerator();
		for(int i=0;i<5;i++){
			System.out.println(gen.next());
		}
/*		for(Coffee c : new CoffeeGenerator(5)){
			System.out.println(c);
		}*/
	}
}
