package test.createsurvey;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import s2c.objects.AddQuestionObjects;
import s2c.testbase.configTest;
import utilities.generateReport;

public class addNPS_Circle extends configTest{
	WebElement npsIcon;
	Logger testLogger;
	ITestResult result;	
	

	public addNPS_Circle()
	{driver=configTest.getDriver();
	testLogger=Logger.getLogger(addNPS_Circle.class);

		}


	@Test
	public void clickNPS() throws InterruptedException
	{	testLogger.info("Clicking on NPS Icon");
		try{
			waitforElementBYXpath(By.xpath(AddQuestionObjects.NPS_Icon));
			{npsIcon=driver.findElement(By.xpath(AddQuestionObjects.NPS_Icon));}
			
			
		npsIcon=driver.findElement(By.xpath(AddQuestionObjects.NPS_Icon));
		npsIcon.click();
		testLogger.info("NPS has been clicked successfully");
		} catch(Exception e){
			testLogger.error("NPS Icon could not be clicked");
			testLogger.error(e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(dependsOnMethods="clickNPS")
	public void addNPS()
	{
		testLogger.info("Creating NPS Circles Question");
		try{waitforElementBYXpath(By.xpath("//iframe"));	
		
		
		
		WebElement e1=driver.findElement(By.xpath("//iframe"));
		String s1=e1.getAttribute("id");			
		driver.switchTo().frame(e1);
		driver.findElement(By.xpath(AddQuestionObjects.NPS_QuestionTextArea)).sendKeys("");
		driver.switchTo().defaultContent();
		WebElement e3=configTest.getDriver().findElement(By.xpath(AddQuestionObjects.NPS_Type));
		Select select=new Select(e3);
		select.selectByVisibleText("Circles");
		List l=configTest.getDriver().findElements(By.xpath(AddQuestionObjects.NPS_ColorOption));
		Iterator c=l.iterator();
		while(c.hasNext())
		{
			WebElement x=(WebElement)c.next();
			System.out.println(x.getText());
			if(x.getText().equals(("No Color") )){x.click();

			}
		}
		driver.findElement(By.xpath(AddQuestionObjects.NPS_Submit)).click();
		
		waitforElementBYXpath(By.xpath(AddQuestionObjects.Toaster_createQuestion));                  // verify confirmation Message
		confirmation_message=driver.findElement(By.xpath(AddQuestionObjects.Toaster_createQuestion)).getText();
		testLogger.info("Confirmation Messsage Received is : "+confirmation_message);
		
		if(!confirmation_message.contains("Question has been saved successfully.")){
			driver.findElement(By.xpath("//div[@class='left_sidebar_footer']/button[3]")).click();
		     throw new Exception();
			}
		
		testLogger.info("NPS Circles Question has been created successfully");
		}catch(Exception e){
			testLogger.info("Problem occured creating NPS Question .");
			testLogger.error(e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@AfterMethod()
	public void initResult(ITestResult result1) throws InterruptedException
	{
		result=result1;
		Thread.sleep(2000);
	}
	
	@AfterClass()
	void setStatusintoReport() throws IOException
	{ 
		testcounter++;
		String status=null;
		int i=result.getStatus();
		switch(i){
		case ITestResult.SUCCESS: 
		{status="PASS";
		generateReport.addPassStatus(testcounter,"ADD NPS_Circles", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"ADD NPS_Circles", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"ADD NPS_Circles", status);
		}}
		
		
		}
	
}
