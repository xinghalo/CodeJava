package xing.test.thinking.chap05;

public class InitialValues {
	boolean t;
	char c;
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	InitialValues reference;
	void print(){
		System.out.println("initial values");
		System.out.println("boolean: "+t);
		System.out.println("char: "+c);
		System.out.println("byte: "+b);
		System.out.println("short: "+s);
		System.out.println("int: "+i);
		System.out.println("long: "+l);
		System.out.println("float: "+f);
		System.out.println("double: "+d);
		System.out.println("reference: "+reference);
	}
	public static void main(String[] args) {
		InitialValues init = new InitialValues();
		init.print();
	}
}
