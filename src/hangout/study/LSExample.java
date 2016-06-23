package hangout.study;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class LSExample {
	public static void main(String[] args) {
		String[] arg = new String[]{ "--block-size=10" };
		testOption(arg);
	}
	static void testOption(String[] args){
		CommandLineParser parser = new DefaultParser();

		// create the Options
		Options options = new Options();
		options.addOption( "a", "all", false, "do not hide entries starting with ." );
		options.addOption( "A", "almost-all", false, "do not list implied . and .." );
		options.addOption( "b", "escape", false, "print octal escapes for nongraphic "+ "characters" );
		options.addOption( OptionBuilder.withLongOpt( "block-size" )
		                                .withDescription( "use SIZE-byte blocks" )
		                                .hasArg()
		                                .withArgName("SIZE")
		                                .create() );
		options.addOption( "B", "ignore-backups", false, "do not list implied entried "+ "ending with ~");
		options.addOption( "c", false, "with -lt: sort by, and show, ctime (time of last " 
		                               + "modification of file status information) with "
		                               + "-l:show ctime and sort by name otherwise: sort "
		                               + "by ctime" );
		options.addOption( "C", false, "list entries by columns" );

		try {
		    CommandLine line = parser.parse( options, args );

		    if( line.hasOption( "block-size" ) ) {
		        System.out.println( line.getOptionValue( "block-size" ) );
		    }
		    HelpFormatter formatter = new HelpFormatter();
		    formatter.printHelp( "ls", options );
		}
		catch( ParseException exp ) {
		    System.out.println( "Unexpected exception:" + exp.getMessage() );
		}
	}
}
