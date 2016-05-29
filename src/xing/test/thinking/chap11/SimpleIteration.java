package xing.test.thinking.chap11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSON;
/**
 * 使用iterator可以返回Iterator.
 * 通过next可以获得下一个元素
 * 通过hasNext判断是否还有下一个元素
 * 通过remove将迭代器元素删除
 * 
 * @author xxh
 *
 */
class Pet{
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Pet() {
	}
	public Pet(String name) {
		this.name = name;
	}
}
public class SimpleIteration {
	public static void main(String[] args) {
		List<Pet> pets = new ArrayList<>();
		pets.add(new Pet("hello"));
		pets.add(new Pet("aaa"));
		pets.add(new Pet("cdf"));
		Iterator<Pet> it = pets.iterator();
		while(it.hasNext()){
			Pet p = it.next();
			System.out.println(p.hashCode());
		}
		System.out.println(JSON.toJSONString(pets));
		
		it = pets.iterator();
		int length = pets.size();
		for(int i=0; i<length; i++){
			it.next();
			it.remove();
		}
		System.out.println(JSON.toJSONString(pets));
	}
}
