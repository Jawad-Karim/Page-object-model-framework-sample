package testScripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

// how to perform database testing in selenium webdriver
// By using JDBC we can perform database testing in selenium webdriver

public class Functional_database_test {
	
	@Test
	public void test1() throws Exception {
		
		//data
		String cust_fName = "jawad";
		String cust_lName = "karim";
		String cust_email = "jawadkarim@gmail.com";
		String cust_pass = "Jawad1234";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.opencart.com/");
		driver.findElement(By.xpath("//*[@class='nav float-end']//following::a[@class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right show']//li[1]")).click();
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("scrollBy(0, 220)");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(cust_fName);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(cust_lName);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(cust_email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(cust_pass);
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		try {
			String confirmMessage = driver.findElement(By.xpath("//hi[text()='your account has been created!']")).getText();
			if(confirmMessage.equals("your account has been created!")) {
				System.out.println("Registration succssful from UI/Application");
			}
			else {
				System.out.println("Registration not successful");
			}
		}
		catch (Exception e) {
			System.out.println("some problem in the application");
		}
		
		// database validation
		Class.forName("com.mysql.jdbc.driver"); //driver loaded
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/openshop", "root", "");
		Statement smt = conn.createStatement();
		String query = "select firstname, lastname, email";		
		ResultSet rs = smt.executeQuery(query);
		
		boolean status = false;
		
		while(rs.next()) {
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			String email = rs.getString("email");
			
			if(cust_fName.equals(firstname) && cust_lName.equals(lastname) && cust_email.equals(email)) {
				System.out.println("Record found in the table || test passed");
				status = true;
				break;
			}
		}
		if(status==false) {
			System.out.println("Record not found in the table || test failed");
		}
	}

}
