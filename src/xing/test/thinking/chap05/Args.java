package xing.test.thinking.chap05;

public class Args {
	static void f(String i,Character ... args){
		System.out.println(i);
		for(Character c : args){
			System.out.println(c);
		}
	}
	static void f(int i,Character ... args){
		System.out.println(i);
		for(Character c : args){
			System.out.println(c);
		}
	}
	public static void main(String[] args) {
		f("123",'a','b','c');
		f(2,'a','b','c');
	}
}
