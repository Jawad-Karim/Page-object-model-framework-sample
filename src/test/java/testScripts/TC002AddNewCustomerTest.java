package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AddNewCustomer;
import pageObjects.LoginPage;

public class TC002AddNewCustomerTest extends BaseClass{

	LoginPage login;
	AddNewCustomer newCust;

	@Test
	public void addNewCustomerPage() throws Exception {		

		login = new LoginPage(driver);
		logger.info("browser started");
		
		login.typeUserName(pro.getProperty("userName"));
		logger.info("valid user name is entered");
		
		login.typePassword(pro.getProperty("password"));
		logger.info("valid password is entered");
		
		login.clickLoginButton();
		logger.info("login button is clicked");
		
		String title = driver.getTitle();
		logger.info("login successful & page title is : "+ title);
		
		Assert.assertEquals(title,  "Guru99 Bank Manager HomePage");
		logger.pass("title verification is successful");

		Thread.sleep(2000);
		newCust = new AddNewCustomer(driver);

		newCust.clickNewCustomer();
		logger.info("clicked on new customer option");
		Thread.sleep(1000);

		driver.navigate().back();   // to handle an uncertain pop-up.
		driver.navigate().forward();

		Thread.sleep(1000);
		newCust.enterCustomerName("Jawad Karim");
		logger.info("entered customer name");
		
		newCust.clickOnFemale();
		logger.info("clicked female button");
		
		newCust.clickOnMale();
		logger.info("clicked male button");
		
		newCust.enterDateOfBirth("21", "12", "1999");
		logger.info("entered customer's date of birth");
		
		newCust.enterAddress("123 Main street");
		logger.info("entered customer's street address");
		
		newCust.enterCityName("main City");
		logger.info("entered customer's city name");
		
		newCust.enterStateName("MO");
		logger.info("entered customer's state name");
		
		newCust.enterPinNo("121");
		logger.info("entered personal pin number");
		
		newCust.enterPhoneNo("12456454355");
		logger.info("entered customer's phone number");
		
		newCust.enterEmail("asd@gmail.com");
		logger.info("entered customer's email");
		
		newCust.enterPassWord("weuryr");
		logger.info("entered password");
		
		newCust.clickOnSubmitButton();
		logger.info("clicked on submit button");
		
		if(alertPresent()==true) {
			
			driver.switchTo().alert().accept();
			logger.info("an alert was poped up and then it was handled");
		}
	}

	public boolean alertPresent() {

		try {
			driver.switchTo().alert();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

}
