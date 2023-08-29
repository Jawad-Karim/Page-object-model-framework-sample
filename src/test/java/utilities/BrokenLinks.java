package utilities;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {

		// link to be verified
		String inputLink = "https://wayne.edu/";
		
		//calling verify method
		verifyBrokenLinks(inputLink);
	}

	public static void verifyBrokenLinks(String inputLink){

		//initialize Chrome browser
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();

		//go to url
		driver.get(inputLink);

		//get the list of links
		List<WebElement> links = driver.findElements(By.tagName("a"));		
		System.out.println("Total links are "+links.size());

		//verify every single link
		for(WebElement link : links){		
			String URL=link.getAttribute("href");
			try{
				URL url = new URL(URL);
				HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
				httpURLConnect.setConnectTimeout(3000);
				httpURLConnect.connect();

				//verify response code is 200 or not !
				if(httpURLConnect.getResponseCode()==200){
				
					System.out.println(URL+" - "+httpURLConnect.getResponseMessage());
				}
				else if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
				
					System.out.println(URL+" : "+httpURLConnect.getResponseMessage() + " : "+ HttpURLConnection.HTTP_NOT_FOUND);
				}
				
				
			} 
			catch (Exception e) {
				System.out.println("Exception  cause : "+ e.getCause());
				System.out.println(" Exception is : " + e.getMessage());
			}
		}
		//print the links
		
		System.out.println("test completed successfully");
	}
}
