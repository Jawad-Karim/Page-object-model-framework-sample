package calendar;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.ScreenShotTaker;

public class Extent_Reports {
	
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest logger;
	
	@Test
	public void testExtentReports() {
		
		
		String timeStamp = new SimpleDateFormat("MM.dd.yyyy__HH.mm.ss").format(new Date());
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("./reports/Spark_"+timeStamp+".html");
		extent.attachReporter(spark);
		
		logger = extent.createTest("MyFirstTest");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		logger.info("browser started");
		
		driver.manage().window().maximize();
		logger.info("window maximized");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("wait is setup");
		
		String imagePath = ScreenShotTaker.take_screenshot(driver, "facebook");
		logger.addScreenCaptureFromPath(imagePath);

		extent.flush();
	}

}
