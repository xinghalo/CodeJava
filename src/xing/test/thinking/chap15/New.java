package xing.test.thinking.chap15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/**
 * 工具类，可以避免创建容器时指定过多的泛型参数类型。
 * 
 * @author xxh
 *
 */
public class New {
	public static <K,V> Map<K,V> map(){
		return new HashMap<K,V>();
	}
	public static <T> List<T> list(){
		return new ArrayList<T>();
	}
	public static <T> LinkedList<T> lList(){
		return new LinkedList<T>();
	}
	public static <T> Set<T> set(){
		return new HashSet<T>();
	}
	public static <T> Queue<T> queue(){
		return new LinkedList<T>();
	}
	public static void main(String[] args) {
		Map<String,List<String>> sls = New.map();
		List<String> ls = New.list();
		LinkedList<String> lls = New.lList();
		Set<String> set = New.set();
		Queue<String> qs = New.queue();
	}
}
