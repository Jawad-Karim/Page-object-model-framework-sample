package utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class SelectUtility {
	
	static Select oselect;
	
	public static void select_by_index(WebElement element, int index) {

		oselect = new Select(element);
		oselect.selectByIndex(index);
	}
	

	public static void select_by_value(WebElement element, String value) {

		oselect = new Select(element);
		oselect.selectByValue(value);
	}
	

	public static void select_by_visibleText(WebElement element, String text) {

		oselect = new Select(element);
		oselect.selectByVisibleText(text);
	}
	
	public static void printAllSelectOptions(WebElement element) {

		Select oselect = new Select(element);
		List<WebElement> allOptions = oselect.getOptions();
		for(WebElement option : allOptions) {
			String optionNames = option.getText();
			Reporter.log("Option : "+ optionNames, true);

		}
	}

}
