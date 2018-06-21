package edu.handong.csee.java.bonushw;

public class Main {

	public static void main(String[] args) {
		
		String inputURL;
		
		getInputCLI input = new getInputCLI();
		inputURL = input.gettingInput(args);
		
		WebReader reader = new WebReader();
		reader.webReading(inputURL);
		
		
	}

}
