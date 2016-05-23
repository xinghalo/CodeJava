package xing.test.thinking.chap10;

public class Parcel9 {
	//这里的参数 不是final，也可以啊
	public Destination destination(final String dest){
		return  new Destination(){
			private String label = dest;
			public String readLabel(){
				return label;
			}
		};
	}
	public static void main(String[] args) {
		Parcel9 p = new Parcel9();
		System.out.println(p.destination("123").readLabel());
	}
}
