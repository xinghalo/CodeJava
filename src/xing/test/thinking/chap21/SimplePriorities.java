package xing.test.thinking.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 通过thread.setPriority()可以设置线程的优先级
 * 
 * @author xxh
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  n'n'n'n'n'n'n */
public class SimplePriorities implements Runnable{
	private int countDown = 5;
	private volatile double d;
	private int priority;
	public SimplePriorities(int priority) {
		this.priority = priority;
	}
	public String toString() {
		return Thread.currentThread() + ":" + countDown;
	}
	@Override
	public void run() {
		Thread.currentThread().setPriority(priority);
		
		while(true){
			for(int i=1; i<10000; i++){
				d += (Math.PI + Math.E)/(double)i;
				if(i %1000 == 0)
					Thread.yield();
			}
			System.out.println(this);
			if(--countDown == 0) return;
		}
	}
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0; i<5; i++){
			exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
		}
		exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		exec.shutdown();
	}
}
