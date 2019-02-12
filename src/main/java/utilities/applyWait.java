package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import s2c.testbase.configTest;

public class applyWait extends configTest {
	
	public static WebDriverWait wait;
	public static void waitforElement(WebElement element)
	{

		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeSelected(element));
		
	}
}
