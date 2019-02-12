package test.createsurvey;

import java.io.IOException;

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

public class addSingleText extends configTest{
	WebElement STIcon;
	Logger testLogger;
	ITestResult result;	
	
	

	public addSingleText()
	{driver=configTest.getDriver();
	testLogger=Logger.getLogger(addSingleText.class);

		}
   
	
	@BeforeClass
	public void checkRUnMode()
	{
		if(!excelConfig.runnabletest.contains("addSingleText")){throw new SkipException("");}		
	}

	@Test
	public void clickSingleText() throws InterruptedException
	{
		testLogger.info("Clicking on Single Text Icon");
		try{waitforElementBYXpath(By.xpath(AddQuestionObjects.SingleText));
		STIcon=driver.findElement(By.xpath(AddQuestionObjects.SingleText));
		STIcon.click();
		testLogger.info("Single Text has been clicked successfully");
		} catch(Exception e){
			testLogger.error("Single Text Icon could not be clicked");
			testLogger.error(e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(dependsOnMethods="clickSingleText")
	public void addSingleText()
	{
		testLogger.info("Creating Single Text Question");
		try{waitforElementBYXpath(By.xpath("//iframe"));	
		WebElement e1=driver.findElement(By.xpath("//iframe"));
		String s1=e1.getAttribute("id");			
		driver.switchTo().frame(e1);
		driver.findElement(By.xpath(AddQuestionObjects.ST_QuestionTextArea)).sendKeys("Single Text Question");
		driver.switchTo().defaultContent();
		waitforElementBYXpath(By.xpath("//div[@class='textAreaHeight']"));  
		driver.findElement(By.xpath("//div[@class='textAreaHeight']")).sendKeys("TEXT");
	
		driver.findElement(By.xpath(AddQuestionObjects.ST_Submit)).click();
	
		
		waitforElementBYXpath(By.xpath(AddQuestionObjects.Toaster_createQuestion));                  // verify confirmation Message
		confirmation_message=driver.findElement(By.xpath(AddQuestionObjects.Toaster_createQuestion)).getText();
		
		testLogger.info("Confirmation Message Received is : "+confirmation_message);
			
		if(!confirmation_message.contains("Question has been saved successfully.")){
			driver.findElement(By.xpath("//div[@class='left_sidebar_footer']/button[3]")).click();
	     throw new Exception();
		}
		
		testLogger.info("Single Text  Question has been created successfully");
		}catch(Exception e){
			testLogger.info("Problem occured creating Single Text Question .");
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
		generateReport.addPassStatus(testcounter,"ADD Single Text", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"ADD Single Text", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"ADD Single Texts", status);
		}}
		
		
		}
	
	  @AfterSuite
		public void closeReport() throws IOException
		{
	    	generateReport.close();
		}
}
