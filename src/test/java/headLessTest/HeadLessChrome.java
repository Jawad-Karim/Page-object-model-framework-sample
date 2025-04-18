package headLessTest;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadLessChrome {
	
	WebDriver driver;

	@Test
	public void chromeHeadless() throws Exception {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");  // or options.addArguments("--headless"); (both works)
		driver = new ChromeDriver(options);
		
		driver.get("https://selenium.dev");
		System.out.println("page opened");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./screenshots/ChromeHeadlessImage.png"));
		
		driver.quit();
	}
	
}
