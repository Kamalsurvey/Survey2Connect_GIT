package s2c.webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import s2c.objects.objects_LoginPage;
import s2c.testbase.configTest;

public class homePage extends basicPage {

	@FindBy(id=objects_LoginPage.create_Survey_button_id)
	WebElement createSurvey_button ;


	public homePage() throws InterruptedException 
	{   Thread.sleep(10000);
	     logger=Logger.getLogger(homePage.class);
		PageFactory.initElements(configTest.getDriver(), this);
		
	}

	public createSurveyScreen clickOnCreateSurvey() 
	{  
		try{
		createSurvey_button.click(); 		
		return new createSurveyScreen();}
		catch(Exception e)
		{
			logger.error("Error ocurred in clicking Create Survey Link");
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
