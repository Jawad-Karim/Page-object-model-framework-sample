package headLessTest;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class HeadLessEdge {

	WebDriver driver;
	
	@Test
	public void edgeHeadless() throws Exception {
		
		EdgeOptions options=new EdgeOptions();
		options.addArguments("--headless");
		driver = new EdgeDriver(options);
		
		driver.get("https://www.browserstack.com/");
		System.out.println("Title is: " +driver.getTitle());
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./screenshots/edgeHeadlessImage.png"));
		
		driver.quit();
	}
}
