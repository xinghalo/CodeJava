package xing.test.thinking.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(2);
		for(int i=0; i<5; i++){
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}
