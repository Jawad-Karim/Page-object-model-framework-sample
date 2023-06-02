package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ScrollUtility {


	static JavascriptExecutor je;


	public static void scrollPage(int pageHeight) {
		//je.executeScript("window.scrollTo(0, pageHeight)");
		je.executeScript("window.scrollBy(0, pageHeight)");


	}


	public static void scrollPageToElement(WebElement element) {
		je.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public static void scrollPageToLocation(WebElement element) {
		je.executeScript("window.scollTo(arguments[0], arguments[1]", element.getLocation().x, element.getLocation().y);

	}


}
