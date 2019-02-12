package s2c.webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import s2c.objects.objects_LoginPage;
import s2c.testbase.configTest;

public class firstPage extends basicPage {

	@FindBy(linkText= objects_LoginPage.Login_Link)
	static WebElement login_link ;

	public firstPage()
	{
		PageFactory.initElements(configTest.getDriver(), this);
		logger=Logger.getLogger(firstPage.class);
	}

	public loginPage clickOnLogin()
	{

		try { 
			configTest.waitforElement(login_link);
			login_link.click();
			return new loginPage();
		  } 
		
		catch(Exception e) {
			logger.error("Error with click on Login Link");
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

