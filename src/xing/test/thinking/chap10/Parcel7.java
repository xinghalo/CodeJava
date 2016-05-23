package xing.test.thinking.chap10;

public class Parcel7 {
	public Contents contents(){
		//匿名内部类
		return new Contents(){
			private int i = 11;
			public int value(){
				return i;
			}
		};
		//相当于
		/*class MyContents extends Contents{
			private int i = 11;
			public int value(){return i;}
		}
		public Contents content(){
			return new MyContents();
		}*/
	}
	public static void main(String[] args) {
		Parcel7 p = new Parcel7();
		Contents c = p.contents();
	}
}
