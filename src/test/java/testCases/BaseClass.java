package testCases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.BrowserFactory;

public class BaseClass {

	public WebDriver driver;

	String baseUrl = "https://demo.guru99.com/V4/index.php";

	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest logger;


	@BeforeSuite
	public void setUp() {

		String timeStamp = new SimpleDateFormat("MM.dd.yyyy__HH.mm.ss").format(new Date());

		extent = new ExtentReports();
		spark = new ExtentSparkReporter("./reports/bank_"+timeStamp+".html");
		extent.attachReporter(spark);

		logger = extent.createTest("iNetBanking");			
		logger.info("suite is set up");		
	}

	//@BeforeClass
	public void startup() {

		driver = BrowserFactory.startBrowser("chrome", baseUrl);
		logger.info("browser started");
	}

	//@AfterMethod
	public void tearDown1() {

		driver.close();
		logger.info("browser closed");
	}

	//@AfterTest
	public void tearDown2() {

		driver.quit();
		logger.info("all opened browsers quitted");
	}

}
