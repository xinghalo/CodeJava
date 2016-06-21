package xing.test.thinking.chap15;

import java.util.List;
import java.util.Map;

public class LimitsOfInference {
	static void f(Map<String, List<? extends Coffee>> map){
		System.out.println("test");
	}
	public static void main(String[] args) {
		f(New.map());
//		f(New.<String,List<Coffee>>map());
	}
}
