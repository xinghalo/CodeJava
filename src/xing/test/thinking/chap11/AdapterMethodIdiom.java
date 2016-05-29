package xing.test.thinking.chap11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
/**
 * 继承ArrayList，然后返回Iterable接口即可。
 * Iterable返回iterator对象。
 * 
 * @author xxh
 *
 * @param <T>
 */
@SuppressWarnings("serial")
class ReversibleArrayList<T> extends ArrayList<T>{
	public ReversibleArrayList(Collection<T> c){
		super(c);
	}
	public Iterable<T> reversed(){
		return new Iterable<T>() {
			public Iterator<T> iterator(){
				return new Iterator<T>(){
					int current = size() -1 ;
					public boolean hasNext(){
						return current > -1;
					}
					public T next(){
						return get(current--);
					}
					public void remove(){
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}
public class AdapterMethodIdiom {
	public static void main(String[] args) {
		ReversibleArrayList<String> ral =  new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
		for(String s : ral){
			System.out.print(s+" ");
		}
		System.out.println();
		for(String s : ral.reversed()){
			System.out.print(s+" ");
		}
		System.out.println();
		
		Collections.shuffle(ral, new Random(47));
		for(String s : ral){
			System.out.print(s+" ");
		}
	}
}