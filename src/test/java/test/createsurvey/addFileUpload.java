package test.createsurvey;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import s2c.objects.AddQuestionObjects;
import s2c.testbase.configTest;
import utilities.generateReport;

public class addFileUpload extends configTest{
	WebElement STIcon;
	Logger testLogger;
	ITestResult result;	
	
	

	public addFileUpload()
	{driver=configTest.getDriver();
	testLogger=Logger.getLogger(addFileUpload.class);

		}


	@Test
	public void clickFileUpload() throws InterruptedException
	{
		testLogger.info("Clicking on FileUpload Icon");
		try{waitforElementBYXpath(By.xpath(AddQuestionObjects.fileUpload_Icon));
		STIcon=driver.findElement(By.xpath(AddQuestionObjects.fileUpload_Icon));
		STIcon.click();
		testLogger.info("FileUpload Icon has been clicked successfully");
		} catch(Exception e){
			testLogger.error("FileUpload Icon could not be clicked");
			testLogger.error(e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(dependsOnMethods="clickFileUpload")
	public void addFile()
	{
		testLogger.info("Creating File Question");
		try{waitforElementBYXpath(By.xpath("//iframe"));	
		WebElement e1=driver.findElement(By.xpath("//iframe"));
		String s1=e1.getAttribute("id");			
		driver.switchTo().frame(e1);
		driver.findElement(By.xpath(AddQuestionObjects.ST_QuestionTextArea)).sendKeys("File Type Question");
		driver.switchTo().defaultContent();
		
	
		driver.findElement(By.xpath(AddQuestionObjects.ST_Submit)).click();
	
		
		waitforElementBYXpath(By.xpath(AddQuestionObjects.Toaster_createQuestion));                  // verify confirmation Message
		confirmation_message=driver.findElement(By.xpath(AddQuestionObjects.Toaster_createQuestion)).getText();
		
		testLogger.info("Confirmation Message Received is : "+confirmation_message);
			
		if(!confirmation_message.contains("Question has been saved successfully.")){
			driver.findElement(By.xpath("//div[@class='left_sidebar_footer']/button[3]")).click();
	     throw new Exception();
		}
		
		testLogger.info("File  Question has been created successfully");
		}catch(Exception e){
			testLogger.info("Problem occured creating Date File Question .");
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
		generateReport.addPassStatus(testcounter,"ADD File", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"ADD File", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"ADD File", status);
		}}
		
		
		}
	
	  @AfterSuite
		public void closeReport() throws IOException
		{
	    	generateReport.close();
		}
}
