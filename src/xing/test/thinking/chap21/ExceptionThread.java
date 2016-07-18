package xing.test.thinking.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable{
	public void run(){
		throw new RuntimeException();
	}
	public static void main(String[] args) {
//		ExecutorService exec = Executors.newCachedThreadPool();
//		exec.execute(new ExceptionThread());
		
		try{
			ExecutorService exec = Executors.newCachedThreadPool();
			exec.execute(new ExceptionThread());
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
