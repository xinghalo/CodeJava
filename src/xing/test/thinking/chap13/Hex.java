package xing.test.thinking.chap13;

public class Hex {
	public static String format(byte[] data){
		StringBuilder result = new StringBuilder();
		int n = 0;
		for(byte b : data){
			//设置数值显示的宽度，不够的用0补位
			if(n%16 == 0){
				result.append(String.format("%05x: ", n));
			}
			result.append(String.format("%02x ", b));
			n++;
			if(n%16 == 0){
				result.append("\n");
			}
		}
		result.append("\n");
		return result.toString();
	}
	public static void main(String[] args) {
		System.out.println(format(Hex.class.toString().getBytes()));
	}
}
