package test.createsurvey;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import s2c.objects.AddQuestionObjects;
import s2c.testbase.configTest;
import s2c.testbase.excelConfig;
import utilities.generateReport;
import utilities.readTestSheet;

public class addSingleChoice extends configTest{
	WebElement singleChoiceIcon;
	Logger testLogger;
	ITestResult result;	
	
	

	public addSingleChoice()
	{driver=configTest.getDriver();
	testLogger=Logger.getLogger(addSingleChoice.class);

		}
	
  
    
    @BeforeClass
	public void checkRUnMode()
	{
		if(!excelConfig.runnabletest.contains("addSingleChoice")){throw new SkipException("");}		
	}

	@Test
	public void clickSingleChoice() throws InterruptedException
	{
		testLogger.info("Clicking on SingleChoice con");
		try{waitforElementBYXpath(By.xpath(AddQuestionObjects.singleChoice));
		singleChoiceIcon=driver.findElement(By.xpath(AddQuestionObjects.singleChoice));
		singleChoiceIcon.click();
		testLogger.info("Single Choice has been clicked successfully");
		} catch(Exception e){
			testLogger.error("Single Choice could not be clicked");
			testLogger.error(e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(dependsOnMethods="clickSingleChoice")
	public void addSingleChoice()
	{
		testLogger.info("Creating Single Choice Question");
		try{waitforElementBYXpath(By.xpath("//iframe"));	
		WebElement e1=driver.findElement(By.xpath("//iframe"));
		String s1=e1.getAttribute("id");			
		driver.switchTo().frame(e1);
		driver.findElement(By.xpath(AddQuestionObjects.dropdown_QuestionTextArea)).sendKeys("Single Choice");
		driver.switchTo().defaultContent();
		
		waitforElementBYXpath(By.xpath("//div[@formarrayname='row']/div[2]//div[@role='textarea']"));
		List<WebElement> l=driver.findElements(By.xpath("//div[@formarrayname='row']/div[2]//div[@role='textarea']"));
		Iterator i=l.iterator();
		while(i.hasNext())
		{
			((WebElement)i.next()).sendKeys(" Option Added ");
			
		}
	
		driver.findElement(By.xpath(AddQuestionObjects.dropdown_Submit)).click();
	
		
		waitforElementBYXpath(By.xpath(AddQuestionObjects.Toaster_createQuestion));                  // verify confirmation Message
		confirmation_message=driver.findElement(By.xpath(AddQuestionObjects.Toaster_createQuestion)).getText();
		
		testLogger.info("Confirmation Message Received is : "+confirmation_message);
			
		if(!confirmation_message.contains("Question has been saved successfully.")){
			driver.findElement(By.xpath("//div[@class='left_sidebar_footer']/button[3]")).click();
	     throw new Exception();
		}
		
		testLogger.info("Single Choice  Question has been created successfully");
		}catch(Exception e){
			testLogger.info("Problem occured creating  Single Choice .");
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
		generateReport.addPassStatus(testcounter,"ADD Single Choice", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"ADD Single Choice", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"ADD Single Choice", status);
		}}
		
		
		}
	
	 
}
