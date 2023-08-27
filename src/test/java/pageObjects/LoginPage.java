package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	//WebDriver driver;
	
	public LoginPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@name='uid']")
	private WebElement userName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "//input[@name='btnLogin']")
	private WebElement logButton;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Log out']")
	private WebElement logout;
	
	public void typeUserName(String id) {
		
		userName.sendKeys(id);
	}
	
	public void typePassword(String pass) {
		
		password.sendKeys(pass);
	}
	
	public void clickLoginButton() {
		
		logButton.click();
	}
	
	public void logOutButton() {
		
		logout.click();
	}

}
