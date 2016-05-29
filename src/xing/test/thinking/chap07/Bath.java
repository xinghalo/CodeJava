package xing.test.thinking.chap07;
class Soap{
	private String s;
	Soap(){
		System.out.println("Soap()");
		s = "Contructor";
	}
	public String toString(){
		return s;
	}
}
public class Bath {
	private String s1="happy",s2="happy",s3,s4;//第一种，在定义对象的时候初始化
	private Soap castille;
	private int i;
	private float toy;
	public Bath(){//第二种，在构造方法中初始化
		System.out.println("Inside Bath()");
		s3 = "Joy";
		toy = 3.14f;
		castille = new Soap();
	}
	//使用实例初始化
	{
		i = 47;
	}
	//在使用对象之前，进行初始化
	public String toString(){
		if(s4 == null)
			s4 = "joy";
		return 
			"s1 = "+s1+"\n"+
			"s2 = "+s2+"\n"+
			"s3 = "+s3+"\n"+
			"s4 = "+s4+"\n"+
			"i = "+i+"\n"+
			"toy = "+toy+"\n"+
			"castille = "+castille+"\n";
	}
	public static void main(String[] args) {
		Bath b = new Bath();
		System.out.println(b);
	}
}
