package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameUtility {

	public static WebDriver driver;

	public FrameUtility(WebDriver driver) {
		this.driver = driver;
	}

	public static void switchToFrame(int FrameIndex) {
		driver.switchTo().frame(FrameIndex);
	}

	public static void switchToFrame(String FrameName) {
		driver.switchTo().frame(FrameName);
	}

	public static void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}


}
