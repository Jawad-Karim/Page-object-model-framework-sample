package utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadFileUsingRobotClass {

	
	public static void fileUploader(String url, String filePath) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		driver.findElement(By.xpath("//button[@id='browse']")).click();
		Robot robot = new Robot();
		
		//select file path
		StringSelection getPath = new StringSelection(filePath);
		
		//copy file path to clipboad
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(getPath, null);
		Thread.sleep(1000);
		
		//paste the file path
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);				
		
		System.out.println("file is uploaded successfully");
	}
	
	@Test
	public static void uploadFile() throws Exception {
		
		String Url = "https://altoconvertpdftojpg.com/";
		String filePath = "C:\\Users\\jawad\\Downloads\\Postman-SNT-Presentation.pptx";
		fileUploader(Url, filePath);
		
	}

}
