package s2c.webpages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import s2c.testbase.configTest;

public class singleChoiceScreen extends basicPage {

	@FindBy(xpath="//body[@id='tinymce']")
	WebElement questiontext;

	@FindBy(xpath="//div[@class='textAreaHeight']")
	List<WebElement> option1 ;

	@FindBy(xpath="//button[@class='btn s2c_cancel_btn']")
	WebElement submitButton;

	

	public singleChoiceScreen() throws Exception
	{
		Thread.sleep(10000);			
		WebElement frame=configTest.getDriver().findElement(By.cssSelector("div.mce-tinymce.mce-container.mce-panel>div>div>iframe"));
		String f=frame.getAttribute("id");
		configTest.waitforElement(frame);
		configTest.getDriver().switchTo().frame(f);
		PageFactory.initElements(configTest.getDriver(),this);
		logger=logger.getLogger(addQuestions.class);
	}

	public clickMultiChoice enterText()
	{	try{	
		
		configTest.waitforElement(questiontext);
		questiontext.sendKeys("Single Choice Question");
		//try{Thread.sleep(5000L);} catch(Exception e){}
		System.out.println("Entering text in Single choice");
		configTest.getDriver().switchTo().defaultContent();	
		configTest.waitforElements(option1);
		Iterator i=option1.iterator();
		while(i.hasNext())
		{    
			WebElement e=(WebElement)i.next();
			configTest.waitforElement(e);
			e.sendKeys("AA");
		}

		configTest.waitforElement(submitButton);
		submitButton.click();

		return new clickMultiChoice();

	}catch(Exception e){ 

		logger.error("Error ocurred while entering text in single choice");
		logger.info("     ");
		logger.error("************************* SELENIUM LOG ***************************");
		logger.info("     ");
		logger.error(e.getMessage());
		logger.error("     ");
		logger.error("************************* SELENIUM LOG ***************************");
		logger.info("         ");
		e.printStackTrace();

		return null;}
	}


}
