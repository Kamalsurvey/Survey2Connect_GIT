package s2c.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import s2c.objects.objects_LoginPage;
import s2c.testbase.configTest;

public class startButtonPage extends basicPage {
	
	@FindBy(xpath=objects_LoginPage.start_BUtton_xpath)
	WebElement startButton;
	
	public startButtonPage() throws Exception
	{   Thread.sleep(10000L);
	    logger=logger.getLogger(startButtonPage.class);
		PageFactory.initElements(configTest.getDriver() ,this);
	}
		
	
	public addQuestions clickButton()
	{
		 
	try{
		startButton.click();
		return new addQuestions();
	} catch(Exception e){
		
		logger.error("Error ocurred clicking on Start Button");
		logger.info("     ");
		logger.error("************************* SELENIUM LOG ***************************");
		logger.info("     ");
		logger.error(e.getMessage());
		logger.error("     ");
		logger.error("************************* SELENIUM LOG ***************************");
		logger.info("         ");
		e.printStackTrace();
	   	
	   return null; 
	   }
	}
	
	
}
