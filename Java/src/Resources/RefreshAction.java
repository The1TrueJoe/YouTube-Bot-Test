/**
 * Executes a refresh action using Chrome default refresh key
 * 
 * @author JosephTelaak
 * 
 * @version 1
 * @date_created 5/30/19
 * @date_edited 6/1/19
 */
 

package Resources;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


public class RefreshAction {
	
	// Default key
	private int key = KeyEvent.VK_F5;

	
	/**
	 * 
	 * Executes a refresh action
	 * 
	 * @param keyboard
	 * @throws InterruptedException
	 * 
	 * @author JosephTelaak
	 * 
	 * @version 1
	 * @date_created 5/30/19
	 * @date_edited 6/1/19
	 */
	
	public RefreshAction(Robot keyboard) throws InterruptedException {
		keyboard.keyPress(key);
		TimeUnit.MILLISECONDS.sleep(10);
		keyboard.keyRelease(key);
	}
	
}
