package xing.test.thinking.chap21;

import java.util.concurrent.TimeUnit;

class InnerThread1{
	private int countDown = 5;
	private Inner inner;
	private class Inner extends Thread {
		Inner(String name){
			super(name);
			start();
		}
		public void run(){
			try{
				while(true){
					System.out.println(this);
					if(--countDown == 0) return;
					sleep(10);
				}
			}catch(InterruptedException e){
				System.out.println(e);
			}
		}
		public String toString(){
			return getName() + ":" + countDown;
		}
	}
	public InnerThread1(String name) {
		inner = new Inner(name);
	}
}
class InnerThread2{
	private int countDown = 5;
	private Thread t;
	public InnerThread2(String name){
		t = new Thread(name){
			public void run(){
				try{
					while(true){
						System.out.println(this);
						if(--countDown == 0) return;
						sleep(10);
					}
				}catch(InterruptedException e){
					System.out.println(e);
				}
			}
			public String toString(){
				return getName() + ":" + countDown;
			}
		};
		t.start();
	}
}
class InnerRunnable1{
	private int countDown = 5;
	private Inner inner;
	private class Inner implements Runnable {
		Thread t;
		Inner(String name){
			t = new Thread(name);
			t.start();
		}
		public void run(){
			try{
				while(true){
					System.out.println(this);
					if(--countDown == 0) return;
					TimeUnit.MILLISECONDS.sleep(10);
				}
			}catch(InterruptedException e){
				System.out.println(e);
			}
		}
		public String toString(){
			return t.getName() + ":" + countDown;
		}
	}
	public InnerRunnable1(String name) {
		inner = new Inner(name);
	}
}
class InnerRunnable2{
	private int countDown = 5;
	private Thread t;
	public InnerRunnable2(String name){
		t = new Thread(new Runnable(){
			public void run() {
				try{
					while(true){
						System.out.println(this);
						if( --countDown == 0) return;
						TimeUnit.MILLISECONDS.sleep(100);
					}
				}catch(InterruptedException e){
					System.out.println(e);
				}
			}
			public String toString(){
				return Thread.currentThread().getName() + ":" +countDown;
			}
		},name);
		t.start();
	}
}
class ThreadMethod{
	private int countDown = 5;
	private Thread t;
	private String name;
	public ThreadMethod(String name){
		this.name = name;
	}
	public void runTask(){
		if(t == null){
			t = new Thread(name){
				public void run(){
					try{
						while(true){
							System.out.println(this);
							if(--countDown == 0) return;
							sleep(10);
						}
					}catch (InterruptedException e) {
						System.out.println(e);
					}
				}
				public  String toString(){
					return getName() + ":" + countDown;
				}
			};
			t.start();
		}
	}
}
public class ThreadVariations {
	public static void main(String[] args) {
//		new InnerThread1("inner thread1");
//		new InnerThread2("inner thread2");
		new InnerRunnable1("inner runnable1");
//		new InnerRunnable2("inner runnable2");
//		new ThreadMethod("ThreadMethod").runTask();
	}
}
