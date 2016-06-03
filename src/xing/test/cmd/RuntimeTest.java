package xing.test.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RuntimeTest {
	public static void main(String[] args) {
		Process process = null;
		try {
			process = Runtime.getRuntime().exec("ipconfig /all");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			String line;
			InputStream is = process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"GBK"));
		
			while(null != (line = br.readLine())){
				System.out.println(line);
			}
			System.out.println("---------------------------------------------------------------------------------------");
			InputStream is_error = process.getErrorStream();
			BufferedReader br_error = new BufferedReader(new InputStreamReader(is_error,"GBK"));
		
			while(null != (line = br_error.readLine())){
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
