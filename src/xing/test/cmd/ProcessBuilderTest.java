package xing.test.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class ProcessBuilderTest {
	public static void main(String[] args) {
		try{
			 String[] cmds = {"ipconfig","/all"};
			 ProcessBuilder builder = new ProcessBuilder(cmds);    
			 //输出环境变量
			 Map<String,String> en = builder.environment();
			 for(String key : en.keySet()){
				 System.out.println(key+" : "+en.get(key));
			 }
			//输出工作目录
			 System.out.println(builder.directory());
			 System.out.println(System.getProperty("user.dir"));
			 
			 //合并输出流和错误流
			 builder.redirectErrorStream(true);    
			 
			 //启动进程
			 Process process = builder.start();    
			 
			 //获得输出流
			 BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));    
			 String line = null;    
			 while (null != (line = br.readLine())){    
			 	System.out.println(line);
			 }    
		}catch(IOException e){
			e.printStackTrace();
		}
	   
	}
}
