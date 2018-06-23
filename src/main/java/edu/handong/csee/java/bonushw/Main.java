package edu.handong.csee.java.bonushw;


import java.util.ArrayList;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class Main {
	
	static String path;
	static String urlAddress;
	boolean help;
	boolean verbose;

	public static void main(String[] args) { 
		
		Main main = new Main();
		main.run(args);
		
		WebReader reader = new WebReader();
		ArrayList<String> inputLines = reader.webReading(urlAddress);
		
		FileWriter fileWriter = new FileWriter();
		fileWriter.fileWriting(path, inputLines);
		
	}
	 
	private void run(String[] args) {
		Options options = createOptions();

		if(parseOptions(options, args)){
			if (help){ 
				printHelp(options);
				return;
			}

			// path is required (necessary) data so no need to have a branch.
			System.out.println("You provided \"" + urlAddress + "\" as the value of the option u");
			System.out.println("You provided \"" + path + "\" as the value of the option d");
			

			// TODO show the number of files in the path

			if(verbose) {

				// TODO list all files in the path

				System.out.println("Your program is terminated. (This message is shown because you turned on -v option!");
			}
		}
		System.exit(0);
	}


	// Parsing Stage
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);
			
			urlAddress = cmd.getOptionValue("u");
			path = cmd.getOptionValue("d");
			verbose = cmd.hasOption("v");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	// Definition Stage
	private Options createOptions() {
		Options options = new Options();

		// add options by using OptionBuilder
		options.addOption(Option.builder("u").longOpt("urlAddress")
				.desc("Set an address of URL to read")
				.hasArg()
				.argName("URL address to read")
				.required()
				.build());
		
		// add options by using OptionBuilder
				options.addOption(Option.builder("d").longOpt("path")
						.desc("Set a path of a directory or a file to display")
						.hasArg()
						.argName("Path name to display")
						.required()
						.build());
				
		// add options by using OptionBuilder
		options.addOption(Option.builder("v").longOpt("verbose")
				.desc("Display detailed messages!")
				//.hasArg()     // this option is intended not to have an option value but just an option
				.argName("verbose option")
				//.required() // this is an optional option. So disabled required().
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());

		return options;
	}

	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "CLI test program";
		String footer ="\nPlease report issues at https://github.com/lifove/CLIExample/issues";
		formatter.printHelp("CLIExample", header, options, footer, true);
	}



}
