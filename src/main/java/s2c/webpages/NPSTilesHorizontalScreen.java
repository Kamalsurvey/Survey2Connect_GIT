package s2c.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import s2c.testbase.configTest;

public class NPSTilesHorizontalScreen extends basicPage {
	
	@FindBy(xpath="//body[@id='tinymce']")
	WebElement questionText;
	
	public NPSTilesHorizontalScreen() throws InterruptedException
	{
		Thread.sleep(10000);
		System.out.println("A");
		WebElement frame=configTest.getDriver().findElement(By.cssSelector("div.mce-tinymce.mce-container.mce-panel>div>div>iframe"));
		String frame_id=frame.getAttribute("id");		
		configTest.waitforElement(frame);
		System.out.println("Waiting for frame ");
		Thread.sleep(5000);
		configTest.getDriver().switchTo().frame(frame_id);	
		System.out.println("C");
	
		
		PageFactory.initElements(configTest.getDriver(), this);
		
	}
	
	
	public void createNPS()
	{
		configTest.waitforElement(questionText);
		questionText.sendKeys("NPS QUESTION");	
		
	}

}

