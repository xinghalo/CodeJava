package xing.test.thinking.chap15;
class Automobile{}
//只能持有单个对象的类
public class Holder1 {
		private Automobile a;
		public Holder1(Automobile a){
			this.a = a;
		}
		Automobile get(){
			return a;
		}
}
