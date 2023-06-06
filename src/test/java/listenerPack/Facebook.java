package listenerPack;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Facebook {
	
	@Test
	public void createAccount() {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[starts-with(@id, 'u_0_0')]")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("jawad");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("karim");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("46575757");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Lhgkd78");
		
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(month);
		monthSelect.selectByIndex(4);
		
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select daySelect = new Select(day);
		daySelect.selectByValue("11");
		
		WebElement yr = driver.findElement(By.xpath("//select[@id='year']"));
		Select yrSelect = new Select(yr);
		yrSelect.selectByVisibleText("1986");
		
		List <WebElement> gender = driver.findElements(By.xpath("//input[@name='sex']"));
		gender.get(0).click();
		gender.get(1).click();
		
	}

}
