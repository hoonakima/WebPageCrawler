package edu.handong.csee.java.bonushw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.cli.Options;

public class WebReader {
	
	public void webReading(String inputURL) {
		
		String urlAddress = inputURL;
			
		Options options = new Options();
		
		
		try {
			URL myURL = new URL(urlAddress);
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(myURL.openStream()));
				
				String inputLine;
				while((inputLine = reader.readLine()) != null)
					System.out.println(inputLine);
				reader.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		}

}
