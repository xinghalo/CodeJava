package xing.test.thinking.chap14;
class Candy {
	static {
		System.out.println("Loading Candy");
	}
}
class Gum {
	static {
		System.out.println("Loading Gum");
	}
}
class Cookie {
	static {
		System.out.println("Cookie");
	}
}
public class SweetShop {
	public static void main(String[] args) {
		System.out.println("inside main");
		new Candy();
		System.out.println("After creating Candy");
		try{
			Class.forName("xing.test.thinking.chap14.Gum");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		System.out.println("After creating Gum");
		new Cookie();
		System.out.println("After creating Cookie");
	}
}
