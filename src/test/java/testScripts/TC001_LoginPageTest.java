package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;

public class TC001_LoginPageTest extends BaseClass{

	LoginPage login;

	@Test(priority=1)
	public void login_With_validID_validPassword() {

		login = new LoginPage(driver);

		login.typeUserName(pro.getProperty("userName"));
		logger.info("valid user name is entered");

		login.typePassword(pro.getProperty("password"));
		logger.info("valid password is entered");

		login.clickLoginButton();
		logger.info("login button is clicked");

		String title = driver.getTitle();
		logger.info("page title is : "+ title);

		Assert.assertEquals(title,  "Guru99 Bank Manager HomePage");
		logger.pass("test is passed");

	}

	//@Test(priority=2)
	public void login_With_Invalid_ID_valid_Password() {

		login = new LoginPage(driver);

		login.typeUserName("xxxx");
		logger.info("INvalid user name is entered");

		login.typePassword(pro.getProperty("password"));
		logger.info("valid password is entered");

		login.clickLoginButton();
		logger.info("login button is clicked");

		String title = driver.getTitle();
		logger.info("page title is : "+ title);
		
		Assert.assertEquals(title,  "Guru99 Bank Manager HomePage");
		logger.pass("test is passed");

	}

	//@Test(priority=3)
	public void login_With_Valid_ID_inValid_Password() {

		login = new LoginPage(driver);
		login.typeUserName(pro.getProperty("userName"));
		logger.info("valid user name is entered");

		login.typePassword(pro.getProperty("password")+"xx");
		logger.info("inValid password is entered");

		login.clickLoginButton();
		logger.info("login button is clicked");

		String title = driver.getTitle();
		logger.info("page title is : "+ title);
		
		Assert.assertEquals(title,  "Guru99 Bank Manager HomePage");
		logger.pass("test is passed");


	}
	
	

	//@Test(priority=4)
	public void login_With_INvalidID_INvalidPassword() {

		login = new LoginPage(driver);
		login.typeUserName(pro.getProperty("userName")+"xx");
		logger.info("valid user name is entered");

		login.typePassword(pro.getProperty("password")+"xx");
		logger.info("inValid password is entered");

		login.clickLoginButton();
		logger.info("login button is clicked");

		String title = driver.getTitle();
		logger.info("page title is : "+ title);
		
		Assert.assertEquals(title,  "Guru99 Bank Manager HomePage");
		logger.pass("test is passed");
	}
}
