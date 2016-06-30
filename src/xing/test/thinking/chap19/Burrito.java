package xing.test.thinking.chap19;
import static xing.test.thinking.chap19.Spiciness.*;
/**
 * 使用静态引入，可以直接使用枚举的元素值
 * 
 * @author xxh
 */
public class Burrito {
	Spiciness degree;
	public Burrito(Spiciness degree){
		this.degree = degree;
	}
	public String toString(){
		return "Burrito is "+ degree;
	}
	public static void main(String[] args) {
		System.out.println(new Burrito(NOT));
		System.out.println(new Burrito(MEDIUM));
		System.out.println(new Burrito(HOT));
	}
}
