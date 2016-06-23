package hangout.study;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class DateApp {
	public static void main(String[] args) {
		String[] arg = {"-t"};
//		String[] arg = {};
		try {
			testOption(arg);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	static void testOption(String[] args) throws ParseException{
		Options options = new Options();
		options.addOption("t", false, "display current time");
		
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse( options, args);
		
		if(cmd.hasOption("t")) {
			System.out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
		}else {
			System.out.println((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
		}
	}
}
