package grid_with_lambda_Test;

import java.net.URI;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {

	public static WebDriver driver = null;

	public static WebDriver startBrowserWithLambda(String browser, String browserVersion, String os) throws Exception {

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

		String uri = "https://hub.lambdatest.com/wd/hub";

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName(os);
			browserOptions.setBrowserVersion(browserVersion);
			browserOptions.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URI(uri).toURL(), browserOptions);
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions browserOptions = new FirefoxOptions();
			browserOptions.setPlatformName(os);
			browserOptions.setBrowserVersion(browserVersion);
			browserOptions.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URI(uri).toURL(), browserOptions);
		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions browserOptions = new EdgeOptions();
			browserOptions.setPlatformName(os);
			browserOptions.setBrowserVersion(browserVersion);
			browserOptions.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URI(uri).toURL(), browserOptions);
		}

		return driver;
	}

}
