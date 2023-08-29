package base;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.BrowserFactory;
import utilities.ScreenShotTaker;

public class BaseClass {

	public WebDriver driver;	
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;

	public File file;
	public FileInputStream fis;
	public Properties pro;

	@BeforeTest
	public void setup() throws Exception {

		//extent report setup
		spark = new ExtentSparkReporter("./reports/extent.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);

		//add environment details to extent report
		extent.setSystemInfo("machine", "myPC");
		extent.setSystemInfo("OS", "window 10");
		extent.setSystemInfo("user", "Jawad");
		extent.setSystemInfo("browser", "chrome");

		//configuration for look and feel in extent report
		spark.config().setDocumentTitle("Bank Login Page");
		spark.config().setReportName("login page test");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setTimeStampFormat("EEE MMM dd, yyyy. hh : mm : ss a '('zzz')'");

		//setup properties file
		file = new File("./configuration/config.properties");
		fis = new FileInputStream(file);
		pro = new Properties();
		pro.load(fis);

	}

	
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(Method method, String BrowserName) {
		
		logger = extent.createTest(method.getName());
		driver = BrowserFactory.startBrowser(BrowserName);
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass(MarkupHelper.createLabel(result.getName()+" test is passed", ExtentColor.GREEN));
			
			String screenShotPath = ScreenShotTaker.take_screenshot(driver, result.getName());
			logger.addScreenCaptureFromPath(screenShotPath);
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" test is skipped", ExtentColor.ORANGE));
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" test is failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+" test is failed", ExtentColor.RED));

			String screenShotPath = ScreenShotTaker.take_screenshot(driver, result.getName());
			logger.addScreenCaptureFromPath(screenShotPath);
		}
		//driver.close();
		driver = null;
	}
	
	@AfterTest
	public void afterClass() {
		
		extent.flush();
	}


}
