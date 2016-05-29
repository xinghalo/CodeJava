package xing.test.thinking.chap11;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/**
 * ListIterator支持前向，后向的迭代
 * 
 * @author xxh
 */
public class ListIteration {
	public static void main(String[] args) {
		List<Pet> pets = new ArrayList<>();
		pets.add(new Pet("abc"));
		pets.add(new Pet("bcd"));
		
		ListIterator<Pet> listIterator = pets.listIterator();
		while(listIterator.hasNext()){
			Pet p = listIterator.next();
			System.out.println(p.getName());
			System.out.println(listIterator.nextIndex());
			System.out.println(listIterator.previousIndex());
		}
	}
}
