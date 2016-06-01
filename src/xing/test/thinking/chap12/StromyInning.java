package xing.test.thinking.chap12;
class BaseBallException extends Exception {}
class Foul extends BaseBallException {}
class Strike extends BaseBallException {}
/**
 * 1 异常不属于方法重载的一部分，方法类型由 名字 和 参数类型 组成。
 * 2 派生类构造器不能捕获基类抛出的异常
 * 3 接口不能给已经存在的方法添加异常
 * 4 子类可以继承父类声明的异常信息
 * 
 * @author xxh
 *
 */
abstract class Inning{
	public Inning() throws BaseBallException {}
	public void event() throws BaseBallException {}
	public abstract void atBat() throws Strike, Foul;
	public void walk(){}
}

class StormException extends Exception{}
class RainedOut extends Exception{}
class PopFoul extends Foul{}

interface Storm{
	public void event() throws RainedOut;
	public void ranHard() throws RainedOut;
}

public class StromyInning extends Inning implements Storm{
	public StromyInning() throws RainedOut,BaseBallException{}
	public StromyInning(String s) throws Foul, BaseBallException{}
	
	public void walk(){}
//	public void event() throws RainedOut{}
//	public void event() throws BaseBallException{}//如果基类或者接口抛出异常，子类是不能抛出的
	public void event(){}
	
	@Override
	public void ranHard() throws RainedOut {
	}
	@Override
	public void atBat() throws PopFoul {
	}
	public static void main(String[] args) {
		try{
			StromyInning si = new StromyInning();
			si.atBat();
		}catch(PopFoul e){
			e.printStackTrace();
		}catch(RainedOut e){
			e.printStackTrace();
		}catch(BaseBallException e){
			e.printStackTrace();
		}
		try{
			Inning i = new StromyInning();
			i.atBat();
		}catch(Strike e){
			e.printStackTrace();
		}catch(Foul e){
			e.printStackTrace();
		}catch(RainedOut e){
			e.printStackTrace();
		}catch(BaseBallException e){
			e.printStackTrace();
		}
	}
	
}
