package xing.test.thinking.chap11;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
/**
 * PriorityQueue可以按照数字或者字母顺序返回。
 * 
 * @author xxh
 *
 */
public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		Random rand = new Random(47);
		for(int i=0; i<10; i++){
			priorityQueue.offer(rand.nextInt(i+10));
		}
		QueueDemo.printQ(priorityQueue);
		
		List<Integer> ints = Arrays.asList(25,22,10,3,5,1,2,3,4,10);
		priorityQueue = new PriorityQueue<>(ints);
		QueueDemo.printQ(priorityQueue);
		
		priorityQueue = new PriorityQueue<>(ints.size(),Collections.reverseOrder());
		priorityQueue.addAll(ints);
		QueueDemo.printQ(priorityQueue);
		
		String fact = "EDUCATION SHOULD ESCHEW OBFUSACTION";
		List<String> strings = Arrays.asList(fact.split(" "));
		PriorityQueue<String> stringPQ = new PriorityQueue<>(strings);
		QueueDemo.printQ(stringPQ);
		
		stringPQ = new PriorityQueue<>(strings.size(),Collections.reverseOrder());
		stringPQ.addAll(strings);
		QueueDemo.printQ(stringPQ);
		
		Set<Character> charSet = new HashSet<Character>();
		for(char c : fact.toCharArray()){
			charSet.add(c);
		}
		PriorityQueue<Character> characterPQ = new PriorityQueue<>(charSet);
		QueueDemo.printQ(characterPQ);
	}
}
