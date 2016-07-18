package xing.test.thinking.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 通过设置Thread的异常捕获处理器，可以拦截到所有的异常信息
 * 
 * @author xxh
 */
public class SettingDufaultHandler {
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}
}
