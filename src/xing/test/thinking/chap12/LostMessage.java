package xing.test.thinking.chap12;

//import org.eclipse.jdt.internal.compiler.batch.Main;
/**
 * 异常丢失
 * 
 * @author xxh
 *
 */
class VeryImportantException extends Exception {
	public String toStrng(){
		return "A very important exception!";
	}
}
class HohumException extends Exception {
	public String toString(){
		return "A trivial exception";
	}
}
public class LostMessage {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}
	void dispose() throws HohumException{
		throw new HohumException();
	}
	public static void main(String[] args){
		try{
			LostMessage lm = new LostMessage();
			try{
				lm.f();
			}finally{
				lm.dispose();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
