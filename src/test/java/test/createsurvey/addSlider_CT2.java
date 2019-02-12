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

public class addSlider_CT2 extends configTest{
	WebElement dropdownIcon;
	Logger testLogger;
	ITestResult result;	
	
	

	public addSlider_CT2()
	{driver=configTest.getDriver();
	testLogger=Logger.getLogger(addSlider_CT2.class);

		}


	@Test
	public void clickSlider() throws InterruptedException
	{
		testLogger.info("Clicking on Slider Icon");
		try{waitforElementBYXpath(By.xpath(AddQuestionObjects.slider_Icon));
		dropdownIcon=driver.findElement(By.xpath(AddQuestionObjects.slider_Icon));
		dropdownIcon.click();
		testLogger.info("Slider has been clicked successfully");
		} catch(Exception e){
			testLogger.error("Slider Icon could not be clicked");
			testLogger.error(e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(dependsOnMethods="clickSlider")
	public void addSlider()
	{
		testLogger.info("Creating Slider Question");
		try{waitforElementBYXpath(By.xpath("//iframe"));	
		WebElement e1=driver.findElement(By.xpath("//iframe"));
		String s1=e1.getAttribute("id");			
		driver.switchTo().frame(e1);
		driver.findElement(By.xpath(AddQuestionObjects.dropdown_QuestionTextArea)).sendKeys("Slider Question Continuous Type 2");
		driver.switchTo().defaultContent();
		
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='ans_settings_div']//div[@class='slider_type_inp']/label"));
		list.get(1).click();
		
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
		
		testLogger.info("Slider Continuous Type 2 Question has been created successfully");
		}catch(Exception e){
			testLogger.info("Problem occured creating Dropdown Slider Continuous Type 2 Question .");
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
		generateReport.addPassStatus(testcounter,"ADD Slider Continuos Type2 Slider", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"ADD Slider Continuos Type2", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"ADD Slider Continuos Type2", status);
		}}
		
		
		}
	
	  @AfterSuite
		public void closeReport() throws IOException
		{
	    	generateReport.close();
		}
}
