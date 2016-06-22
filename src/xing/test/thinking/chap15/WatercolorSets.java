package xing.test.thinking.chap15;

import java.util.HashSet;
import java.util.Set;

public class WatercolorSets {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>();
		set1.add("A");
		set1.add("B");
		set1.add("C");
		Set<String> set2 = new HashSet<>();
		set2.add("B");
		set2.add("D");
		System.out.println(set1);
		System.out.println(set2);
		System.out.println(Sets.union(set1, set2));
		System.out.println(Sets.intersection(set1, set2));
		System.out.println(Sets.difference(set1, set2));
		System.out.println(Sets.complement(set1, set2));
	}
}
