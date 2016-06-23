package hangout.study;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class HangoutMainTest {
/*	public class Option {
		String flag, opt;

		public Option(String flag, String opt) {
			this.flag = flag;
			this.opt = opt;
		}
	}*/

	/**
	 * parse the input command arguments
	 * 
	 * @param args
	 * @return
	 * @throws ParseException
	 */
	private static CommandLine parseArg(String[] args) throws ParseException {
		Options options = new Options();
		options.addOption("h", false, "usage help");
		options.addOption("help", false, "usage help");
		options.addOption("f", true, "configuration file");
		options.addOption("l", true, "log file");
		options.addOption("w", true, "filter worker number");
		options.addOption("v", false, "print info log");
		options.addOption("vv", false, "print debug log");
		options.addOption("vvvv", false, "print trace log");

		CommandLineParser paraer = new BasicParser();
		CommandLine cmdLine = paraer.parse(options, args);

		if (cmdLine.hasOption("help") || cmdLine.hasOption("h")) {
			/*usage();*/
			
			HelpFormatter hf = new HelpFormatter();
	        hf.setWidth(110);
	        hf.printHelp("testApp", options, true);
	        
			System.exit(-1);
		}

		// TODO need process invalid arguments
		if (!cmdLine.hasOption("f")) {
			throw new IllegalArgumentException("Required -f argument to specify config file");
		}

		return cmdLine;
	}

	/**
	 * print help information
	 */
	private static void usage() {
		StringBuilder helpInfo = new StringBuilder();
		helpInfo.append("-h").append("\t\t\thelp command").append("\n").append("-help").append("\t\t\thelp command")
				.append("\n").append("-f").append("\t\t\trequired config, indicate config file").append("\n")
				.append("-l").append("\t\t\tlog file that store the output").append("\n").append("-w")
				.append("\t\t\tfilter worker numbers").append("\n").append("-v").append("\t\t\tprint info log")
				.append("\n").append("-vv").append("\t\t\tprint debug log").append("\n").append("-vvvv")
				.append("\t\t\tprint trace log").append("\n");

		System.out.println(helpInfo.toString());
	}

	public static void main(String[] args) throws Exception {
		String[] arg = {"-h","xx.file"};
		CommandLine cmdLine = parseArg(arg);
		System.out.println(cmdLine.getOptionValue("f"));
	}
}
