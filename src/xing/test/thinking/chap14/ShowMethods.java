package xing.test.thinking.chap14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
	private static String usage = "usage: ShowMethods";
	private static Pattern p = Pattern.compile("\\w+\\.");
	public static void main(String[] args) {
		if(args.length < 1){
			System.out.println(usage);
//			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName("xing.test.thinking.chap14.ShowMethods");
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			for(Method method : methods){
				System.out.println(p.matcher(method.toString()).replaceAll(" "));
			}
			for(Constructor ctor : ctors){
				System.out.println(p.matcher(ctor.toString()).replaceAll(" "));
			}
			/*if(args.length == 1){
				for(Method method : methods){
					System.out.println(p.matcher(method.toString()).replaceAll(" "));
				}
				for(Constructor ctor : ctors){
					System.out.println(p.matcher(ctor.toString()).replaceAll(" "));
				}
			}else{
				for(Method method : methods){
					if(method.toString().indexOf(args[1]) != -1){
						System.out.println(p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				}
				for(Constructor ctor : ctors){
					if(ctor.toString().indexOf(args[1]) != -1){
						System.out.println(p.matcher(ctor.toString()).replaceAll(" "));
						lines++;
					}
				}
			}*/
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
