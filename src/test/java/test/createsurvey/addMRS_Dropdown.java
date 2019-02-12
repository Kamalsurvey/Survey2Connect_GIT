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

public class addMRS_Dropdown extends configTest{
	WebElement mrsddIcon;
	Logger testLogger;
	ITestResult result;	
	
	

	public addMRS_Dropdown()
	{driver=configTest.getDriver();
	testLogger=Logger.getLogger(addMRS_Dropdown.class);

		}


	@Test
	public void clickMRS_dropdown() throws InterruptedException
	{
		testLogger.info("Clicking on MRS DD Question");
		try{waitforElementBYXpath(By.xpath(AddQuestionObjects.mrs_dropdown));
		mrsddIcon=driver.findElement(By.xpath(AddQuestionObjects.mrs_dropdown));
		mrsddIcon.click();
		testLogger.info("MRS DD has been clicked successfully");
		} catch(Exception e){
			testLogger.error("MRS  DD could not be clicked");
			testLogger.error(e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(dependsOnMethods="clickMRS_dropdown")
	public void addMRS_DropdownData()
	{
		testLogger.info("Creating MRS DD Question");
		try{waitforElementBYXpath(By.xpath("//iframe"));	
		WebElement e1=driver.findElement(By.xpath("//iframe"));
		String s1=e1.getAttribute("id");			
		driver.switchTo().frame(e1);
		driver.findElement(By.xpath(AddQuestionObjects.mrs_QuestionTextArea)).sendKeys("MRS DD Question");
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
		
		testLogger.info("MRS Dropdown  Question has been created successfully");
		}catch(Exception e){
			testLogger.info("Problem occured creating MRS Dropdown Question .");
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
		generateReport.addPassStatus(testcounter,"ADD MRS DD", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"ADD  MRS DD", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"ADD  MRS DD", status);
		}}
		
		
		}
	
	  @AfterSuite
		public void closeReport() throws IOException
		{
	    	generateReport.close();
		}
}
