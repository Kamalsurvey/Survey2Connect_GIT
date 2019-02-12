package s2c.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import s2c.objects.objects_LoginPage;
import s2c.testbase.configTest;

public class createSurveyScreen extends basicPage {
	
	@FindBy(id=objects_LoginPage.survey_name_id)
	WebElement surveyName;
	
	@FindBy(xpath=objects_LoginPage.create_button_xpath)
	WebElement CreateButton;
	
	
	public createSurveyScreen() throws InterruptedException
	{
		Thread.sleep(5000L);
		logger.getLogger(createSurveyScreen.class);
		PageFactory.initElements(configTest.getDriver(),this);
		
	}

	public startButtonPage enterSurveyName()
	{
		try{
		configTest.waitforElement(surveyName);
		surveyName.sendKeys("First Automation Survey");
		configTest.waitforElement(CreateButton);			
		CreateButton.click();		
		
		return new startButtonPage();}
		
		catch(Exception e){
			
			logger.error("Error ocurred while entering survey Name");
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
