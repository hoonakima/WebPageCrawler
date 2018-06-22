package edu.handong.csee.java.bonushw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.commons.cli.Options;

public class WebReader {
	
	public ArrayList<String> webReading(String urlAddress) {
		
	    ArrayList<String> inputLines = new ArrayList<String>();
	    
			
		Options options = new Options();
		
		
		try {
			
			URL myURL = new URL(urlAddress);
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(myURL.openStream(), "UTF-8"));
				
				String inputLine;
				while((inputLine = reader.readLine()) != null) {
					inputLines.add(inputLine);
				}	
				reader.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return inputLines;
		
		}

}
