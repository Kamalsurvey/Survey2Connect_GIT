package test.createsurvey;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class addGRS_Slider extends configTest{
	WebElement grsIcon;
	Logger testLogger;
	ITestResult result;	
	
	

	public addGRS_Slider()
	{driver=configTest.getDriver();
	testLogger=Logger.getLogger(addGRS_Slider.class);

		}


	@Test
	public void clickGRS_Slider() throws InterruptedException
	{
		testLogger.info("Clicking on GRS Question");
		try{waitforElementBYXpath(By.xpath(AddQuestionObjects.grs_Icon));
		grsIcon=driver.findElement(By.xpath(AddQuestionObjects.grs_Icon));
		grsIcon.click();
		testLogger.info("GRS  has been clicked successfully");
		} catch(Exception e){
			testLogger.error("GRS could not be clicked");
			testLogger.error(e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test(dependsOnMethods="clickGRS_Slider")
	public void addGRS_Dislike()
	{
		testLogger.info("Creating GRS Slider Question");
		try{waitforElementBYXpath(By.xpath("//iframe"));	
		WebElement e1=driver.findElement(By.xpath("//iframe"));
		String s1=e1.getAttribute("id");			
		driver.switchTo().frame(e1);
		
		driver.findElement(By.xpath(AddQuestionObjects.grs_QuestionTextArea)).sendKeys("GRS  Slider  Question");
		driver.switchTo().defaultContent();
		
		waitforElementBYXpath(By.xpath(AddQuestionObjects.grs_type_dd));
		driver.findElement(By.xpath(AddQuestionObjects.grs_type_dd)).click();
		
		waitforElementBYXpath(By.xpath(AddQuestionObjects.grs_type_slider));
		WebElement q=driver.findElement(By.xpath(AddQuestionObjects.grs_type_slider));
		q.click();
		
		testLogger.info("Type selected as Slider");
		driver.switchTo().defaultContent();

	    
	  Actions action=new Actions(driver);
		
	waitforElementBYXpath(By.cssSelector("span.custom_checkbox_txt"));
	List<WebElement> s=	driver.findElements(By.cssSelector("span.custom_checkbox_txt"));
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOf(s.get(0)));
	s.get(0).click();
	
	
	WebElement r1=driver.findElement(By.xpath("//span[@class='textarea_expanded']//div[@role='textarea']"));
	r1.sendKeys("R1");
	Thread.sleep(1000);
	action.sendKeys(Keys.ENTER).perform();
	Thread.sleep(1000);
	action.sendKeys("R2").perform();
	
	wait.until(ExpectedConditions.visibilityOf(s.get(1)));
	s.get(1).click();
	
	WebElement c1=driver.findElement(By.xpath("//div[@formarrayname='col']//span[@class='textarea_expanded']//div[@role='textarea']"));
	c1.sendKeys("C1");
	c1.sendKeys(Keys.TAB);

	for(int i=2;i<=5;i++){
		Thread.sleep(1000);
		action.sendKeys("C"+i).perform();
		if(i<5){
		action.sendKeys(Keys.TAB).perform();
		}
	
	}
	
	
	
		driver.findElement(By.xpath(AddQuestionObjects.mrs_Submit)).click();
	
		
		waitforElementBYXpath(By.xpath(AddQuestionObjects.Toaster_createQuestion));                  // verify confirmation Message
		confirmation_message=driver.findElement(By.xpath(AddQuestionObjects.Toaster_createQuestion)).getText();
		
		testLogger.info("Confirmation Message Received is : "+confirmation_message);
			
		if(!confirmation_message.contains("Question has been saved successfully.")){
			driver.findElement(By.xpath("//div[@class='left_sidebar_footer']/button[3]")).click();
	     throw new Exception();
		}
		
		testLogger.info("GRS Slider Question has been created successfully");
		}catch(Exception e){
			testLogger.info("Problem occured creating GRS Slider Question .");
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
		generateReport.addPassStatus(testcounter,"ADD GRS Slider ", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"ADD  GRS Slider ", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"ADD  GRS Slider ", status);
		}}
		
		
		}
	
	  @AfterSuite
		public void closeReport() throws IOException
		{
	    	generateReport.close();
		}
}
