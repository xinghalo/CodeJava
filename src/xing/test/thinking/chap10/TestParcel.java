package xing.test.thinking.chap10;
interface Destination{
	String readLabel();
}
interface Contents{
	int value();
}
class Parcel4{
	//隐藏内部类
	private class PContents implements Contents{
		private int i = 11;
		public int value(){
			return i;
		}
	}
	//无法在外部构建
	protected class PDestination implements Destination{
		private String label;
		private PDestination(String whereTo) {
			label = whereTo;
		}
		public String readLabel(){
			return label;
		}
	}
	public Destination destination(String s){
		return new PDestination(s);
	}
	public Contents contents(){
		return new PContents();
	}
}
public class TestParcel {
	public static void main(String[] args) {
		Parcel4 p = new Parcel4();
		Contents c = p.contents();
		Destination d = p.destination("Tasnima");
		System.out.println(c.value());
		System.out.println(d.readLabel());
	}
}
