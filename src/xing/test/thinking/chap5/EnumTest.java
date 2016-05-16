package xing.test.thinking.chap5;

enum Test{
	A,B,C,D,E
}

public class EnumTest {
	public static void main(String[] args) {
		for(Test t : Test.values()){
			System.out.println(t+" "+t.ordinal());
		}
	}
}
