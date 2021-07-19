/**
 * This establishes a connection to a web server to parse json
 * data for necessary information
 * 
 * /**
 * Executes a CMD command 
 * 
 * @author JosephTelaak
 * 
 * @version 2
 * @date_created 5/30/19
 * @date_edited 6/1/19
 */

package Resources;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.json.JSONObject;

public class JSONServerConnection {
	
	// json file
	JSONObject json;
	
	/**
	 * Connects to web server
	 * 
	 * @param address
	 * 
	 * @author JosephTelaak
	 * 
	 * @version 1
	 * @date_created 5/30/19
	 * @date_edited 6/1/19
	 */
	
	public JSONServerConnection(String address) {
		// Necessary objects
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		
		try {
			// Establish connection
			System.out.println("Opening connection.....");
			URL url = new URL(address);
			urlConn = url.openConnection();
			System.out.println("Opened");
			
			// Console output
			System.out.println("Retrieving json.....");
			
			// Timeout
			if (urlConn != null) {
				urlConn.setReadTimeout(60 * 1000);
			}
			
			// Pull information
			if (urlConn != null && urlConn.getInputStream() != null) {
				// Input stream
				in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
				
				// Reader object
				BufferedReader bufferedReader = new BufferedReader(in);
			
				// If file exist
				if (bufferedReader != null) {
					int cp;
					
					// Build string
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					
					// Close 
					bufferedReader.close();
				}
			}
			
			// Console output
			System.out.println("json retrieved");
			
		// Close
		in.close();
		
		} catch (Exception e) {
			// Exception
			throw new RuntimeException("Exception while calling URL:"+ address, e);
		} 
		
		// Sets json object
		System.out.println("Converting output to json");
		json = new JSONObject(sb.toString());
	}
	
	/**
	 * This method gets particular data from json object
	 * 
	 * @param key
	 * @return data
	 * 
	 * 
	 * @author JosephTelaak
	 * 
	 * @version 1
	 * @date_created 5/30/19
	 * @date_edited 6/1/19
	 */
	
	public String getData(String key) {
		// Return data
		System.out.println("Getting data at " + key);
		return json.getString(key);
	}
	
	/**
	 * Main test method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Print example data
		System.out.println(new JSONServerConnection("http://10.0.0.60/URL.json").getData("URL"));
	}
}
