package headLessTest;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class HeadLessFirefox {
	
	WebDriver driver;
	
	@Test
	public void firefoxHeadless() throws Exception {
		
		FirefoxOptions options=new FirefoxOptions();
		options.addArguments("--headless");
		driver=new FirefoxDriver(options);
		
		driver.get("https://www.browserstack.com/");
		System.out.println("Title is: " +driver.getTitle());
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./screenshots/fierfoxHeadlessImage.png"));
		
		driver.quit();
		
	}

}
