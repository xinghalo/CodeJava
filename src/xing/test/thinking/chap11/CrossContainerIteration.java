package xing.test.thinking.chap11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;
/**
 * 通过Iterator可以忽略容器类型，以相同的方式使用
 * 
 * @author xxh
 *
 */
public class CrossContainerIteration {
	public static void display(Iterator<Pet> it){
		while(it.hasNext()){
			Pet p = it.next();
			System.out.println(p.getName());
		}
	}
	public static void main(String[] args) {
		ArrayList<Pet> pets = new ArrayList<>();
		LinkedList<Pet> pets_linked = new LinkedList<>();
		HashSet<Pet> hashSet = new HashSet<Pet>();
		TreeSet<Pet> treeSet = new TreeSet<Pet>();
		
		display(pets.iterator());
		display(pets_linked.iterator());
		display(hashSet.iterator());
		display(treeSet.iterator());
	}
}
