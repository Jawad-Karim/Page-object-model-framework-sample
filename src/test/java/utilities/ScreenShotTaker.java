package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotTaker {

	static String screenShotPath = null;

	public static String take_screenshot(WebDriver driver, String screenshotName) {

		try {
			String timeStamp = new SimpleDateFormat("MM.dd.yyyy__HH.mm.ss").format(new Date());

			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(System.getProperty("user.dir")+"./screenShots/"+screenshotName+"_"+timeStamp+".png");
			FileUtils.copyFile(srcFile, destFile);

			screenShotPath = destFile.getAbsolutePath();			
		} 
		catch (Exception e) {
			System.out.println("Exception : "+ e.getMessage());
		}
		return screenShotPath;
	}

	/*	// add screenShot to testNG email-able report (works in java 8)
		 
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("screenShotsFolder//screenshotName.png"));
		
		// right click on screenShot > properties > copy path		
		// add a hyperlink for screenShot to testNG email-able report. it will open on the same tab
		Reporter.log("<a href=\" screen\\shot\\path \">do_a_screenShot_name </a>");
		
		// add a hyperlink for screenShot to testNG email-able report. it will open on a new tab
		Reporter.log("<a target=\"_blank\" href=\" screen\\shot\\path \"> do_a_screenShot_name </a>");
		
		//Add screenshot on the same page with logs to testNG email-able report.
		Reporter.log("<img src=\" screen\\shot\\path \">do_a_screenShot_name </a>");
		
		 */

}
