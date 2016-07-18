package xing.test.thinking.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionTHread2 implements Runnable{
	public void run(){
		Thread t = Thread.currentThread();
		System.out.println("run() by "+t);
		System.out.println("eh = "+t.getUncaughtExceptionHandler());
		throw new RuntimeException();
	}
}
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught "+e);
	}	
}
class HandlerThreadFactory implements ThreadFactory{
	public Thread newThread(Runnable r) {
		System.out.println(this+" creating new thread");
		Thread t = new Thread(r);
		System.out.println("craeted "+t);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("eh  ="+t.getUncaughtExceptionHandler());
		return t;
	}
}
public class CaptureUncaughtException {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExceptionTHread2());
	}
}
