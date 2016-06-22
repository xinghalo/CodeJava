package xing.test.thinking.chap15;

import java.util.HashSet;
import java.util.Set;

public class Sets {
	/**
	 * 合并两个集合
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static <T> Set<T> union(Set<T> a,Set<T> b){
		Set<T> result = new HashSet<>(a);
		result.addAll(b);
		return result;
	}
	/**
	 * 娶两个集合的交集
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static <T> Set<T> intersection(Set<T> a,Set<T> b){
		Set<T> result = new HashSet<>(a);
		result.retainAll(b);
		return result;
	}
	/**
	 * 取第一个集合中与第二个集合不同的元素
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static <T> Set<T> difference(Set<T> a,Set<T> b){
		Set<T> result = new HashSet<>(a);
		result.removeAll(b);
		return result;
	}
	/**
	 * 除了交集之外的元素
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static <T> Set<T> complement(Set<T> a,Set<T> b){
		return difference(union(a,b), intersection(a, b));
	}
}
