package xing.test.thinking.chap21;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 可以通过isDone()判断线程是否执行结束
 * 可以通过get()获取结果，如果没有执行会一直阻塞
 * 
 * @author xxh
 */
class TaskWithResult implements Callable<String>{
	private int id;
	public TaskWithResult(int id){
		this.id = id;
	}
	@Override
	public String call() throws Exception {
		return "result of TaskWithResult "+id;
	}
}
public class CallableDemo {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<>();
		for(int i=0; i<10; i++){
			results.add(exec.submit(new TaskWithResult(i)));
		}
		for(Future<String>  fs : results){
			try{
				System.out.println(fs.get());
			}catch(InterruptedException e){
				System.out.println(e);
				return;
			}catch(ExecutionException e){
				System.out.println(e);
			}finally{
				exec.shutdown();
			}
		}
	}
}
