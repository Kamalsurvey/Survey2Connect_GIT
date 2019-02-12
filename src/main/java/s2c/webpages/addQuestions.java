package s2c.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import s2c.testbase.configTest;

public class addQuestions extends basicPage {

	@FindBy(xpath="//div[@class='ques_types'][1]")
	WebElement singleChoice;

	public addQuestions() throws Exception
	{
	       Thread.sleep(5000L);
		   logger=logger.getLogger(addQuestions.class);
		   PageFactory.initElements( configTest.getDriver(), this);
	}

   
	public singleChoiceScreen addSingleChoice()
	{
		try{
			configTest.waitforElement(singleChoice);
			singleChoice.click();
		    return new singleChoiceScreen();
		    
		}catch(Exception e){
			logger.error("Error ocurred clicking on Single Choice Question");
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


