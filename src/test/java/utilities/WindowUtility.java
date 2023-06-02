package utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowUtility {
	
	
	public static void switchToMainWindow(WebDriver driver) {

		String mainWindow = driver.getWindowHandle();
		driver.switchTo().window(mainWindow); 	
	}
	
	
	
	public static void switchToChildWindow(WebDriver driver) {
		
		String mainWindow = driver.getWindowHandle();

		Set <String> windowSet = driver.getWindowHandles();
		Iterator <String> itr = windowSet.iterator();

		while(itr.hasNext()) {

			String childWindow = itr.next();
			if(!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
			}

		}
	}

	


	public static boolean switchToRigtWindow(WebDriver driver, String titleWord) {

		Set <String> windowSet = driver.getWindowHandles();
		List <String> windowList = new ArrayList <String>(windowSet);

		for(String window : windowList) {

			String title = driver.switchTo().window(window).getTitle();
			
			if(title.contains(titleWord)) {
				return true;
			}
		}
		return false;
	}
}