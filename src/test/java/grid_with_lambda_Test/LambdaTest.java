package grid_with_lambda_Test;

import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
 : to generate capabilities with different options..
 https://www.lambdatest.com/capabilities-generator/
 
 : URL class is deprecated from java 20. 
 so use like this -> URL url = new URI("https://example.com").toURL();
 */

public class LambdaTest {

	// @Test
	public void execute() throws Exception {

		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("133");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "mdshah404");
		ltOptions.put("accessKey", "LT_p0aVnbV4JRyRX9VHsWRtEMvCsRNulsJhOaVPd4WkxYX0HaV");
		ltOptions.put("resolution", "1920x1080");
		ltOptions.put("build", "Selenium");
		ltOptions.put("project", "my project");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-java");
		browserOptions.setCapability("LT:Options", ltOptions);

		WebDriver driver = new RemoteWebDriver(new URI("https://hub.lambdatest.com/wd/hub").toURL(), browserOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("my userName");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("my password");
		driver.findElement(By.xpath("//div[contains(@id, 'u_0_4')]")).click();

		driver.close();
	}

	@Parameters({ "browser", "browserVersion", "os" })
	//@Test
	public void facebookHomePage(String browser, String browserVersion, String os) throws Exception {

		WebDriver driver = driver_with_parameter(browser, browserVersion, os);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("my userName");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("my password");
		driver.findElement(By.xpath("//div[contains(@id, 'u_0_4')]")).click();
		driver.quit();
	}

	public static WebDriver driver_with_parameter(String browser, String browserVersion, String os) throws Exception {

		WebDriver driver = null;

		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "mdshah404");
		ltOptions.put("accessKey", "LT_p0aVnbV4JRyRX9VHsWRtEMvCsRNulsJhOaVPd4WkxYX0HaV");
		ltOptions.put("geoLocation", "US/NYC");
		ltOptions.put("build", "v.1.1");
		ltOptions.put("project", "Automation testing for Facebook");
		String[] customBuildTags = { "Login Page" };
		ltOptions.put("buildTags", customBuildTags);
		ltOptions.put("name", "Login Page test");
		String[] customTags = { "Login with valid credintial" };
		ltOptions.put("tags", customTags);
		ltOptions.put("networkThrottling", "Regular 4G");
		ltOptions.put("selenium_version", "4.18.1");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-java");

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName(os);
			browserOptions.setBrowserVersion(browserVersion);
			browserOptions.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URI("https://hub.lambdatest.com/wd/hub").toURL(), browserOptions);
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions browserOptions = new FirefoxOptions();
			browserOptions.setPlatformName(os);
			browserOptions.setBrowserVersion(browserVersion);
			browserOptions.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URI("https://hub.lambdatest.com/wd/hub").toURL(), browserOptions);
		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions browserOptions = new EdgeOptions();
			browserOptions.setPlatformName(os);
			browserOptions.setBrowserVersion(browserVersion);
			browserOptions.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URI("https://hub.lambdatest.com/wd/hub").toURL(), browserOptions);
		}

		return driver;
	}
	
	@Parameters({ "browser", "browserVersion", "os" })
	@Test
	public void facebookLoginPage(String browser, String browserVersion, String os) throws Exception {

		WebDriver driver = BrowserFactory.startBrowserWithLambda(browser, browserVersion, os);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("my userName");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("my password");
		driver.findElement(By.xpath("//div[contains(@id, 'u_0_4')]")).click();
		driver.quit();
	}

}
