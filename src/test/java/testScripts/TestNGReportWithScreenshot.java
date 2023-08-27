package testScripts;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGReportWithScreenshot {
	
	WebDriver driver;
	
	@Test
	public void reporter() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("browser is opened");
		
		
		
		driver.get("http://facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Reporter.log("facebook home page opened");
		
		//String path = ScreenShotTaker.take_screenshot(driver, "facebook");
		//Reporter.log("<a target=\"_blank\" href=\"path\">Screenshot</a>");
		
		//Reporter.log("<img src=\"C:\\Users\\jawad\\eclipse-workspace\\page_object_model\\screenShots\"/>");
	}

}
