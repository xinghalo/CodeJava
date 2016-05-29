package xing.test.thinking.chap11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
/**
 * Queue可以直接从LinkedList中转换出
 * 
 * 主要方法是：
 * 
 * offer add
 * peek element
 * poll remove
 * 
 * 
 * @author xxh
 *
 */
public class QueueDemo {
	public static void printQ(Queue queue){
		while(queue.peek() != null){
			System.out.print(queue.remove()+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(47);
		for(int i=0; i<10; i++){
			queue.offer(rand.nextInt(i+10));
		}
		printQ(queue);
		
		Queue<Character> qc = new LinkedList<Character>();
		for(char c : "Brontosaurus".toCharArray()){
			qc.offer(c);
		}
		printQ(qc);
	}
}
