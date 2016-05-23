package xing.test.thinking.chap10;

public class DotNew {
	public class Inner{}
	public static void main(String[] args) {
		DotNew dotNew = new DotNew();
		DotNew.Inner dni = dotNew.new Inner();//通过.new创建内部对象
	}
}
