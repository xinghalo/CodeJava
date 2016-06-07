package xing.test.thinking.chap13;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class ThreatAnalyzer {
	static String threatData = "1.1.1.1@01/10/2005\n"+
			"1.1.1.2@02/10/2005\n"+
			"1.1.1.3@03/10/2005\n"+
			"1.1.1.4@04/10/2005\n"+
			"1.1.1.5@05/10/2005\n";
	public static void main(String[] args) {
		Scanner scanner = new Scanner(threatData);
		String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@(\\d{2}/\\d{2}/\\d{4})";
		while(scanner.hasNext(pattern)){
			scanner.next(pattern);
			MatchResult match = scanner.match();
			String ip = match.group(1);
			String date = match.group(2);
			System.out.format("Threat on %s from %s\n",date,ip);
		}
	}
}
