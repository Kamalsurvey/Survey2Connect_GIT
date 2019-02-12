package s2c.webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import s2c.objects.objects_LoginPage;
import s2c.testbase.configTest;

public class loginPage extends basicPage{

	@FindBy(name=objects_LoginPage.email_name)
	WebElement email;

	@FindBy(name=objects_LoginPage.password_name)
	WebElement password ;

	@FindBy(id=objects_LoginPage.Login_id)
	WebElement Login_Button ;
	
	
	public loginPage()
	{
		logger=Logger.getLogger(loginPage.class);
		PageFactory.initElements(configTest.getDriver(), this);
	}

	public homePage doLogin(String username , String pass)
	{
		try{
			configTest.waitforElement(email);
			email.sendKeys(username);
			configTest.waitforElement(password);
			password.sendKeys(pass);
			configTest.waitforElement(Login_Button);
		    Login_Button.click();
		    return new homePage();
		}
		catch(Exception e)
		{
			logger.error("Error ocurred on Login Page while filling Username / Password ");
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


