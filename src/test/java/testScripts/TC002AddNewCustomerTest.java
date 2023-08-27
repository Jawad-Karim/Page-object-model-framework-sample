package testScripts;

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
		login.typeUserName(pro.getProperty("userName"));
		login.typePassword(pro.getProperty("password"));
		login.clickLoginButton();

		Thread.sleep(2000);

		newCust = new AddNewCustomer(driver);

		newCust.clickNewCustomer();
		Thread.sleep(1000);
		
		driver.navigate().back();
		driver.navigate().forward();

		Thread.sleep(1000);
		newCust.enterCustomerName();
		newCust.clickOnFemale();
		newCust.clickOnMale();
		newCust.enterDateOfBirth("21", "12", "1999");
		newCust.enterCustomerName();
		newCust.enterAddress("123 Main street");
		newCust.enterCityName("main City");
		newCust.enterStateName("MO");
		newCust.enterPinNo("121");
		newCust.enterPhoneNo("12456454355");
		newCust.enterEmail("asd@gmail.com");
		newCust.enterPassWord("weuryr");
		newCust.clickOnSubmitButton();
		
		if(alertPresent()==true) {
			
			driver.switchTo().alert().accept();
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
