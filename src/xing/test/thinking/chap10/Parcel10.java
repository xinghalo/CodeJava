package xing.test.thinking.chap10;

public class Parcel10 {
	//不是final也能执行
	public Destination destination(final String dest,final float price){
		return new Destination(){
			private int cost;
			{
				cost = Math.round(price);
				if(cost > 100)
					System.out.println("Over buget");
			}
			private String label = dest;
			public String readLabel(){
				return label;
			}
		};
	}
	public static void main(String[] args) {
		Parcel10 p = new Parcel10();
		Destination d = p.destination("123", 101.395F);
		System.out.println(d.readLabel());
	}
}
