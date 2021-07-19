/**
 * Demonstration console for stream
 * 
 * @author JosephTelaak
 * 
 * @version 1.5
 * @date_created 5/30/19
 * @date_edited 6/1/19
 */

package Main;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class DemoConsole {

	/**
	 * Main method
	 * 
	 * @param args
	 * @throws InterruptedException
	 * @throws FileNotFoundException
	 * 
	 * @author JosephTelaak
	 * 
	 * @version 1.5
	 * @date_created 5/30/19
	 * @date_edited 6/1/19
	 */
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		
		//FileDisplay.removePassed(0);
		
		// Header
		System.out.println("Demonstration debugging console");
		System.out.println("*****************************************\n");

		System.out.println("Opening chrome at " + URL);
		System.out.println("Starting bot......\n");
		
		// Main
		while (true) {
			
			// For every host
			for (int i = 0; i < host_count; i++) {
				// Name
				String hostName;
				
				// Formats host name
				if (i < 10) {
					hostName = "0" + i;
				} else {
					hostName = i + "";
				}
				
				// Prints info
				System.out.println("Refreshing host" + hostName + " @ " + basicIP + hostName);
				TimeUnit.MILLISECONDS.sleep(100);
			}
			
			// Print time
			System.out.println();
			System.out.println("Time: " + LocalDate.now() + " : " + LocalTime.now());
			System.out.println();
			
			// Example views
			long views = 0;
			
			// If milestone is reached
			if (FileDisplay.milestoneReached(views)) {
				FileDisplay.printMilestone(views);
			}
			
			// Wait 
			TimeUnit.SECONDS.sleep((int) (Math.random() * 75) + 30);
		}
		
	}
	// Hosts
	private static int host_count = 15;
	
	// IP and URL
	private static String basicIP = "10.0.0.";
	private static String URL = "https://www.youtube.com/watch?v=v890jeWYP4A&feature=youtu.be";
}
