package xing.test.thinking.chap13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
	static public final String POEM = "Twas brilling, and the slithy toves\n Did gyre and gimble in the wabe.\n All mimsy were the borogoves,\n And the mome raths outgrade.\n\n Beware the Jabberwock, my son,\n The jaws that bite, the claws that catch.\n Beware the Jubjub bird, and shun\n The frumious Bandersnatch.";
	public static void main(String[] args) {
		Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
		while(m.find()){
			for(int j=0; j<= m.groupCount(); j++){
				System.out.println("["+m.group(j)+"]");
			}
		}
	}
}
