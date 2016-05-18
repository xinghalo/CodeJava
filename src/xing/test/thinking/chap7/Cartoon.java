package xing.test.thinking.chap7;
class Art{
	public Art() {
		System.out.println("Art contructor");
	}
}
class Drawing extends Art{
	public Drawing() {
		System.out.println("Drawing contructor");
	}
}
public class Cartoon extends Drawing {
	public Cartoon() {
		System.out.println("Cartoon contructor");
	}
	public static void main(String[] args) {
		Cartoon cartoon = new Cartoon();
	}
}
