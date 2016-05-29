package xing.test.thinking.chap11;

import java.util.Iterator;
/**
 * 仅实现Iterator的集合
 * 
 * @author xxh
 *
 */
class IntegerSequence{
	protected Integer[] ints = new Integer[]{1,2,3};
}
public class NonCollectionSequence extends IntegerSequence{
	public Iterator<Integer> iterator(){
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
	public static void main(String[] args) {
		CollectionSequence c = new CollectionSequence();
		Iterator<Integer> it = c.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
