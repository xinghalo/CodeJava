package xing.test.thinking.chap19;

class RoShamBo{
	public static <T extends Competitor<T>> void match(T a,T b){
		System.out.println(a + " vs. "+b+": "+a.compete(b));
	}
	//这个用法奇特！
	public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass,int size){
		for(int i=0;i<size;i++){
			match(Enums.random(rsbClass),Enums.random(rsbClass));
		}
	}
}
