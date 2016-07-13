package logstash.study;

import java.io.IOException;

public class LogstashTest {
	public static void main(String[] args) {
		 ProcessBuilder builder = new ProcessBuilder("E:\\software\\logstash-2.1.0\\bin\\logstash.bat","-f","json.conf");
		 try {
			Process p = builder.start();
			/*long start = System.currentTimeMillis();
			System.out.println("start! "+start);
			while(isRunning){
				if( (System.currentTimeMillis()-start) > 5000 )
					isRunning = false;
			}
			System.out.println("end! "+System.currentTimeMillis());*/
			try {
				Thread.sleep(20*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("结束");
			p.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
