package xing.test.thinking.chap11;

import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Iterator;
/**
 * 可以自己实现集合
 * 
 * 
 * @author xxh
 *
 */
public class CollectionSequence extends AbstractCollection<Integer>{
	private Integer[] ints = new Integer[]{1,2,3};
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int index = 0;
			public boolean hasNext(){
				return index < ints.length;
			}
			public Integer next(){
				return ints[index++];
			}
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public int size() {
		return ints.length;
	}
	
	public static void main(String[] args) {
		CollectionSequence c = new CollectionSequence();
		Iterator<Integer> it = c.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
