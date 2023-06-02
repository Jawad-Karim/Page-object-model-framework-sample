package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameUtility {

	WebDriver driver;

	public FrameUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToFrame(int FrameIndex) {
		driver.switchTo().frame(FrameIndex);
	}

	public void switchToFrame(String FrameName) {
		driver.switchTo().frame(FrameName);
	}

	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}


}
