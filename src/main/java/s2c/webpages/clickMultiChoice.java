package s2c.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import s2c.testbase.configTest;

public class clickMultiChoice extends basicPage {
	
	@FindBy(xpath="//div[@class='ques_types_row'][1]/div[@class='ques_types'][2]")
	WebElement multiChoiceTab;

	public clickMultiChoice() throws InterruptedException
	{ 
		Thread.sleep(10000L);
		PageFactory.initElements( configTest.getDriver(), this);
		logger=logger.getLogger(clickMultiChoice.class);
	}

   
	public MultiChoiceSCreen clickMultiChoice()
	{
		try{
			configTest.waitforElement(multiChoiceTab);
			multiChoiceTab.click();	
			return new MultiChoiceSCreen();
		}catch(Exception e){
			
			logger.error("Error ocurred while clicking on multiple Options Question");
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
