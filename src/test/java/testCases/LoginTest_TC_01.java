package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.BrowserFactory;
import utilities.ScreenShotTaker;

public class LoginTest_TC_01 extends BaseClass {

	String bankUrl = "https://demo.guru99.com/V4/index.php";
	LoginPage login;
	String screenshot_path;

	@Test
	public void check() {
		System.out.println("test method");
	}

	@Test(dataProvider = "test_data")
	public void loginPageTest(String userName, String passWord) throws Exception {

		ScreenShotTaker.take_screenshot(driver, "facebook");

		driver = BrowserFactory.startBrowser("chrome", bankUrl);
		logger.info("browser opened and url entered");

		login = new LoginPage(driver);

		login.enterUid(userName);
		logger.info("user name entered");

		login.enterPassword(passWord);
		logger.info("pass word entered");

		login.clickLoginButton();
		logger.info("clicked login button");


		if(alertPresent()==true) {

			driver.switchTo().alert().accept();
			System.out.println("alert is handled");
		}
		else {
			System.out.println("not any alert");
		}

		String title = driver.getTitle();
		System.out.println("title : "+title);
		logger.info("title : "+title);

		logger.addScreenCaptureFromPath(screenshot_path);
	}

	@DataProvider(name = "test_data")
	public Object[][] provideData(){

		return new Object[][] {
			{"mngr506815", "dybunAr"},
			{"mng3455792", "UsEz5dU"},
			{"mngr506815", "dybunAr"},
			{"mngr506815", "dybunAr"}

		};	
	}

	public boolean alertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

}

