package xing.test.thinking.chap15;

import java.util.ArrayList;
import java.util.List;
/**
 * 与可变参数共同作用
 * 
 * @author xxh
 *
 */
public class GenericVarargs {
	@SuppressWarnings("unchecked")
	public static <T> List<T> makeList(T... args){
		List<T> result = new ArrayList<>();
		for(T item : args)
			result.add(item);
		return result;
	}
	public static void main(String[] args) {
		List<String> ls = makeList("A");
		System.out.println(ls);
		ls = makeList("A","B","C");
		System.out.println(ls);
		ls = makeList("ABCDEFG".split(""));
		System.out.println(ls);
	}
}
