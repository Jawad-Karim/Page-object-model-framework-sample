package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDateOnCalendar {

	public static void main(String[] args) throws Exception {

		selectDate("July", 2024, 30);
	}
	

	public static void selectDate(String mon, int yr, int day) throws Exception{
		
		WebDriver driver;
		WebDriverWait wait;

		//initialize the date values as String
		String inputMonth = mon;
		String intpuYear = String.valueOf(yr);
		String inputDay = String.valueOf(day);


		//initialize chrome browser and wait
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		//Go to url
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		Thread.sleep(2000);
		driver.navigate().refresh();		
		

		//click on the calendar
		driver.findElement(By.xpath("//div[@class='sc-1gt8xf5-0 cEQQxj']//div[3]//div[1]")).click();

		//get the month year value
		String monthYear = driver.findElement(By.xpath("//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Caption']")).getText();
		String[] monthYEAR = monthYear.split(" ");
		String month = monthYEAR[0];
		String year = monthYEAR[1];

		//click next button until expected month and year displayed
		while(!(month.equalsIgnoreCase(inputMonth)) || !(year.equals(intpuYear))) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			monthYear = driver.findElement(By.xpath("//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Caption']")).getText();

			//update the month year value after clicking NEXT button
			monthYEAR = monthYear.split(" ");
			month = monthYEAR[0];
			year = monthYEAR[1];
		}
		//get the list of all date-elements
		List <WebElement> dateElements = driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));
		for(WebElement dateElement : dateElements) {
			String date = dateElement.getText();
			if(date.equalsIgnoreCase(inputDay)) {
				dateElement.click();
				System.out.println("departure date : "+month+" "+date+", "+year+" is selected");
				break;
			}
		}	 
	}

}
