package xing.test.thinking.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * 通过sleep()方法可以设置线程的睡眠时间
 * 
 * @author xxh
 */
public class SleepingTask extends LiftOff{
	public void run(){
		try{
			while(countDown-- > 0){
				System.out.println(status());
				TimeUnit.MILLISECONDS.sleep(100);
//				Thread.sleep(100);
			}
		}catch(InterruptedException e){
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0; i<5; i++){
			exec.execute(new SleepingTask());
		}
		exec.shutdown();
	}
}
