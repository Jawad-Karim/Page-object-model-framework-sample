package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {

	WebDriver driver;

	public AddNewCustomer(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='New Customer']")
	private WebElement newCustomer;

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	private WebElement custName;

	@FindBy(how = How.XPATH, using = "//input[@value='m']")
	private WebElement genderMale;

	@FindBy(how = How.XPATH, using = "//input[@value='f']")
	private WebElement genderFemale;

	@FindBy(how = How.XPATH, using = "//input[@id='dob']")
	private WebElement birthDate;

	@FindBy(how = How.XPATH, using = "//textarea[@name='addr']")
	private WebElement address;

	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	private WebElement cityName;

	@FindBy(how = How.XPATH, using = "//input[@name='state']")
	private WebElement stateName;

	@FindBy(how = How.XPATH, using = "//input[@name='pinno']")
	private WebElement pinNo;

	@FindBy(how = How.XPATH, using = "//input[@name='telephoneno']")
	private WebElement phoneNo;

	@FindBy(how = How.XPATH, using = "//input[@name='emailid']")
	private WebElement emailId;

	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private WebElement newPassword;

	@FindBy(how = How.XPATH, using = "//input[@name='sub']")
	private WebElement submit;

	public void clickNewCustomer() {

		newCustomer.click();
	}

	public void enterCustomerName() {

		custName.sendKeys("jawad karim");
	}

	public void clickOnMale() {

		genderMale.click();
	}

	public void clickOnFemale() {

		genderFemale.click();
	}

	public void enterDateOfBirth(String dd, String mm, String yyyy) {

		birthDate.sendKeys(dd);
		birthDate.sendKeys(mm);
		birthDate.sendKeys(yyyy);
	}

	public void enterAddress(String AddressTXT) {

		address.sendKeys(AddressTXT);
	}

	public void enterCityName(String city) {

		cityName.sendKeys(city);
	}

	public void enterStateName(String state) {

		stateName.sendKeys(state);
	}

	public void enterPinNo(String pin) {

		pinNo.sendKeys(pin);
	}

	public void enterPhoneNo(String phone) {

		phoneNo.sendKeys(phone);
	}

	public void enterEmail(String email) {

		emailId.sendKeys(email);
	}

	public void enterPassWord(String pass) {

		newPassword.sendKeys(pass);
	}


	public void clickOnSubmitButton() {

		submit.click();
	}

}
