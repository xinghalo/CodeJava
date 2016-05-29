package xing.test.thinking.chap05;

class Book {
	boolean chechedOut = false;
	public Book(boolean checkout) {
		this.chechedOut = checkout;
	}
	void checkIn(){
		this.chechedOut = false;
	}
	protected void finalize(){
		if(chechedOut)
			System.out.println("Error: checked out");
//		super.finalize();
	}
}
public class TerninationCondition {
	public static void main(String[] args) {
		Book book1 = new Book(true);
		book1.checkIn();
		book1 = null;
		System.gc();
		System.out.println("-----------------------");
		new Book(true);
		System.gc();
	}
}
