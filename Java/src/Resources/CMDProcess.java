/**
 * Executes a CMD command 
 * 
 * @author JosephTelaak
 * 
 * @version 1.5
 * @date_created 5/30/19
 * @date_edited 6/1/19
 */

package Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CMDProcess {
	
	/**
	 * Executes a CMD command @param command
	 * 
	 * @param command
	 * @throws IOException
	 * 
	 * @author JosephTelaak
	 * 
	 * @version 1.5
	 * @date_created 5/30/19
	 * @date_edited 6/1/19
	 */
	
	public CMDProcess(String command) throws IOException {
		// Creates process
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
		
		// Redirect errorStream
		builder.redirectErrorStream(true);
		
		// Start process
		Process process = builder.start();
		
		// Read lines
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		
		// Read output
		while (true) {
			// Build string
            line = reader.readLine();
            		
            // Check if available
            if (line == null) {
            	break; 
            }
            
            // Print output
            System.out.println(line);
        }
	}
	
}
