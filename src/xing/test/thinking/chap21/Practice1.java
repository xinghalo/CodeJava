package xing.test.thinking.chap21;

public class Practice1 implements Runnable{
	public Practice1() {
		System.out.println("start()");
	}
	@Override
	public void run() {
		System.out.println("In run 1");
		Thread.yield();
		System.out.println("In run 2");
		Thread.yield();
		System.out.println("In run 3");
		Thread.yield();
		return;
	}
	public static void main(String[] args) {
		for(int i=0; i<10; i++){
			Thread t = new Thread(new Practice1());
			t.start();
		}
	}
}
