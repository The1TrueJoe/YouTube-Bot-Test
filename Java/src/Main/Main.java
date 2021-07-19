/**
 * This is the main file for the bot
 * This stores the run configuration
 * 
 * @author JosephTelaak
 * 
 * @version 1
 * @date_created 5/30/19
 * @date_edited 6/1/19
 */


package Main;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import Resources.CMDProcess;
import Resources.JSONServerConnection;
import Resources.RefreshAction;

public class Main {
	
	// URL
	private static String serverURL = "http://10.0.0.60/URL.json";
	
	/**
	 * This is the main method that executes the YouTubeBot
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws AWTException
	 * 
	 * @author JosephTelaak
	 * 
	 * @version 1
	 * @date_created 5/30/19
	 * @date_edited 6/1/19
	 */
	
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		// Default console display
		System.out.println("\nThis is the YouTube View Bot");
		System.out.println("This program will automatically refresh the page after x time");
		System.out.println();
		System.out.println("Writen by Joseph Telaak");
		System.out.println("**************************************************");
		
		// Establishes keyboard control
		Robot keyboard = new Robot();
		
		// Gets URL from server
		//String url = new JSONServerConnection(serverURL).getData("URL");
		String url = "https://www.youtube.com/watch?v=v890jeWYP4A&feature=youtu.be";

		// Opens chrome.exe at url
		new CMDProcess("start chrome.exe " + url);
		
		// Waits for video to load
		System.out.println("Waiting for load......");
		TimeUnit.SECONDS.sleep(15);
		System.out.println("loaded");
		
		// Main 
		while (true) {
			// Executes refresh 
			System.out.println("Excecuting refresh....");
			new RefreshAction(keyboard);
			System.out.println("Done");
			
			// Watches video for random length
			System.out.println("Waiting....");
			TimeUnit.SECONDS.sleep((int) (Math.random() * 120) + 30);
			//TimeUnit.SECONDS.sleep(15);
		}
		
	}

}
