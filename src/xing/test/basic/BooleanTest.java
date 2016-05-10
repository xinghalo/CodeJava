package xing.test.basic;

public class BooleanTest {
	public static void main(String[] args) {
		//Boolean 有三个可以直接使用的值，分别为FALSE,TRUE,TYPE
		System.out.println(Boolean.FALSE);//false
		System.out.println(Boolean.TRUE);//true
		System.out.println(Boolean.TYPE);//boolean
		
		
		//Boolean有两种初始化方法�?
		/**
		 * 第一种直接传入boolean的�?��??
		 */
		//Allocates a Boolean object representing the value argument.
		Boolean b1 = new Boolean(true);
		Boolean b2 = new Boolean(false);
		/**
		 * 第二种传入字符串，仅当字符串不为null，并且忽略大小写等于true的时候才会为true
		 */
		//Allocates a Boolean object representing the value true if the string argument is not null and is equal, ignoring case, to the string "true".
		Boolean b3 = new Boolean("");
		Boolean b4 = new Boolean("1");
		Boolean b5 = new Boolean("false");
		Boolean b6 = new Boolean("hello");
		Boolean b7 = new Boolean("true");
		Boolean b8 = new Boolean("TrUe");
		
		System.out.println(" is: "+b3);// is: false
		System.out.println("1 is: "+b4);//1 is: false
		System.out.println("false is: "+b5);//false is: false
		System.out.println("hello is: "+b6);//hello is: false
		System.out.println("true is: "+b7);//true is: true
		System.out.println("TrUe is: "+b8);//TrUe is: true
	}
}
