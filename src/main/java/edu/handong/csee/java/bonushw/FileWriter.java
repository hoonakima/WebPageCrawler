package edu.handong.csee.java.bonushw;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileWriter {

	public void fileWriting(String filePath, ArrayList<String> inputLines) {

		String fileName = "index.HTML";
		fileName = filePath.concat(fileName);

		PrintWriter outputStream = null;

		try {
			outputStream = new PrintWriter(fileName);
			
			for(String line : inputLines) {
				outputStream.println(line);
			}
				
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		
		outputStream.close();
		
		

	}
	





}
