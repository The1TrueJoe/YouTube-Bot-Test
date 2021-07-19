/**
 * Shows files in console
 * 
 * @author JosephTelaak
 * 
 * @version 1.5
 * @date_created 5/30/19
 * @date_edited 6/1/19
 */

package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDisplay {
	
	// Path
	private static String path = "//users//joeytelaak//eclipse-workspace//YouTubeBot//DemoConsole//Main//Displays//";
	
	// List of milestones
	private static long[] milestones = {
			1000, 5000, 10000, 25000
	};
	
	// List of files corresponding
	private static File[] files = {
			new File(path + "1k"), new File(path + "5k"), 
			new File(path + "10k"), new File(path + "25k")
	};

	/**
	 * Check if milestone has been reached
	 * 
	 * @param views
	 * @return
	 * 
	 * @author JosephTelaak
	 * 
	 * @version 1.5
	 * @date_created 5/30/19
	 * @date_edited 6/1/19
	 */
	
	public static boolean milestoneReached(long views) {
		// If empty, quit
		if (milestones.equals(null)) {
			return false;
		}
		
		// Returns true on first milestone passed
		for (int i = 0; i < milestones.length; i++) {
			if (views >= milestones[i]) {
				//removePassed(views);
				
				// Return
				return true;
			}
		}
		
		// Return if none
		return false;
	}
	
	/**
	 * Print milestone text
	 * 
	 * @param views
	 * @throws FileNotFoundException
	 * 
	 * @author JosephTelaak
	 * 
	 * @version 1.5
	 * @date_created 5/30/19
	 * @date_edited 6/1/19
	 */
	
	public static void printMilestone(long views) throws FileNotFoundException {
		// Establishes where milestone is
		for (int i = 1; i < milestones.length && i < files.length; i++) {
			if (views >= milestones[i-1] && views < milestones[i]) {
				// Print file
				printFile(files[i-1]);
			}
		}
		
	}
	
	/**
	 * Print file
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 * 
	 * @author JosephTelaak
	 * 
	 * @version 1.5
	 * @date_created 5/30/19
	 * @date_edited 6/1/19
	 */
	
	public static void printFile(File file) throws FileNotFoundException {
		// Scanner object
		Scanner scanner = new Scanner(file);
		
		// While has next line, print
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		
		// Print console
		System.out.println("\n\n");
		
		// Close
		scanner.close();
	}
	
	/*
     *public static void removePassed(long views) {
	 *	if (milestones.length == 0) {
	 *		milestones = null;
	 *		return;
	 *	}
	 *	
	 *	for (int i = 0; i < milestones.length; i++) {
	 *		if (views >= milestones[i]) {
	 *			long[] temp = new long[milestones.length - 1];
	 *			
	 *			for (int x = i; x < milestones.length; x++) {
	 *				temp[x-i] = milestones[x];
	 *			}
	 *			
	 *			milestones = temp;
	 *			return;
	 *		}
	 *	}
	 *}
	 */
}
