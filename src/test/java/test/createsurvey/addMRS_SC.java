package test.createsurvey;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import s2c.objects.AddQuestionObjects;
import s2c.testbase.configTest;
import utilities.generateReport;

public class addMRS_SC extends configTest{
	WebElement mrsIcon;
	Logger testLogger;
	ITestResult result;	
	
	

	public addMRS_SC()
	{driver=configTest.getDriver();
	testLogger=Logger.getLogger(addMRS_SC.class);

		}


	@Test
	public void clickMRS_SC() throws InterruptedException
	{
		testLogger.info("Clicking on MRS Question");
		try{waitforElementBYXpath(By.xpath(AddQuestionObjects.mrs_sc));
		mrsIcon=driver.findElement(By.xpath(AddQuestionObjects.mrs_sc));
		mrsIcon.click();
		testLogger.info("MRS Icon has been clicked successfully");
		} catch(Exception e){
			testLogger.error("MRS  Icon could not be clicked");
			testLogger.error(e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(dependsOnMethods="clickMRS_SC")
	public void addMRS_Data()
	{
		testLogger.info("Creating MRS SC Question");
		try{waitforElementBYXpath(By.xpath("//iframe"));	
		WebElement e1=driver.findElement(By.xpath("//iframe"));
		String s1=e1.getAttribute("id");			
		driver.switchTo().frame(e1);
		driver.findElement(By.xpath(AddQuestionObjects.mrs_QuestionTextArea)).sendKeys("MRS SC Question");
		driver.switchTo().defaultContent();
		
		waitforElementBYXpath(By.xpath("//div[@formarrayname='row']//div[@role='textarea']"));
		List<WebElement> l1=driver.findElements(By.xpath("//div[@formarrayname='row']//div[@role='textarea']"));
		Iterator i1=l1.iterator();
		while(i1.hasNext())
		{
			((WebElement)i1.next()).sendKeys("A");
			
		}
	
		waitforElementBYXpath(By.xpath("//div[@formarrayname='col']//div[@role='textarea']"));
		List<WebElement> l2=driver.findElements(By.xpath("//div[@formarrayname='col']//div[@role='textarea']"));
		Iterator i2=l2.iterator();
		while(i2.hasNext())
		{
			((WebElement)i2.next()).sendKeys("B");
			
		}
	
		driver.findElement(By.xpath(AddQuestionObjects.mrs_Submit)).click();
	
		
		waitforElementBYXpath(By.xpath(AddQuestionObjects.Toaster_createQuestion));                  // verify confirmation Message
		confirmation_message=driver.findElement(By.xpath(AddQuestionObjects.Toaster_createQuestion)).getText();
		
		testLogger.info("Confirmation Message Received is : "+confirmation_message);
			
		if(!confirmation_message.contains("Question has been saved successfully.")){
			driver.findElement(By.xpath("//div[@class='left_sidebar_footer']/button[3]")).click();
	     throw new Exception();
		}
		
		testLogger.info("MRS SC  Question has been created successfully");
		}catch(Exception e){
			testLogger.info("Problem occured creating MRS SC Question .");
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
		generateReport.addPassStatus(testcounter,"ADD MRS SC", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"ADD  MRS SC", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"ADD  MRS SC", status);
		}}
		
		
		}
	
	  @AfterSuite
		public void closeReport() throws IOException
		{
	    	generateReport.close();
		}
}
