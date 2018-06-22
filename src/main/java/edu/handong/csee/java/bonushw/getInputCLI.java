package edu.handong.csee.java.bonushw;

import java.util.ArrayList;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class getInputCLI {

	String outputPath;
	String inputURL;
	
	public ArrayList<String> gettingInput(String[] args) {
		
		Options options = createOptions();
		
		
		if(parseOptions(options, args)){
			
			System.out.println("You provided \"" + inputURL +  "\" as the value of the option u");
			System.out.println("You provided \"" + outputPath +  "\" as the value of the option d");
		}
		
		ArrayList<String> strings = new ArrayList<String>();
		
		strings.add(inputURL);
		strings.add(outputPath);
		
		return strings;
		
	}

	private boolean parseOptions(Options options, String[] args) {
		
		CommandLineParser parser = new DefaultParser();
		
		CommandLine cmd;
		
		try {
			
			cmd = parser.parse(options, args);
			
			inputURL = cmd.getOptionValue("u");
			outputPath = cmd.getOptionValue("d");
			
			
			
		} catch (ParseException e) {
			e.printStackTrace();
			
			return false;
		}
		
		return true;
		
	}
	
	
	
//Definition Stage	
	private Options createOptions() {
		Options options = new Options();
		
		//add options by using OptionBuilder
		options.addOption(Option.builder("d").longOpt("path")                         //Adds an option instance
				         .desc("Set a path of a directory or a file to display")      //Description 
				         .hasArg()
				         .argName("Path name to display")
				         .required()
				         .build());
		
		options.addOption(Option.builder("u").longOpt("input URL")
				.desc("input URL address")
				.hasArg()
				.argName("URL address")
				.required()
				.build());
		
		return options;
	}
	
}
