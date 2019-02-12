package test.createsurvey;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import s2c.testbase.configTest;
import s2c.webpages.addQuestions;
import s2c.webpages.startButtonPage;
import utilities.generateReport;

public class T4clickStartTabTest extends configTest {
	
	public static  addQuestions addquestions;
	public static  startButtonPage startbuttonpage;
	Logger testLogger;
	public T4clickStartTabTest()
	{testLogger=Logger.getLogger(T4clickStartTabTest.class);}
	
	
	@Test
	public void clickStartButton(){
	try{
		testLogger.info("Looking for Start Button to click");
		startbuttonpage=T3startFromScratchTest.getstartButtonPage();
		addquestions=T3startFromScratchTest.getstartButtonPage().clickButton();
		
		if(addquestions==null){throw new Exception();}
		else{testLogger.info("Start Button Clicked Successfully");}
		
	
	}
	catch(Exception e){
		testLogger.info("User could not Click on Start Tab .");
		testLogger.error(e.getMessage());
		e.printStackTrace();
		Assert.fail();
	}
	}
	
	

	public static addQuestions getaddQuestiionsPage()
	{ return addquestions; }
	
	@AfterMethod
	public void setStatusintoReport(ITestResult result) throws IOException
	{
		testcounter++;
		String status=null;
		int i=result.getStatus();
		switch(i){
		case ITestResult.SUCCESS: 
		{status="PASS";
		generateReport.addPassStatus(testcounter,"Click on Start Survey Tab", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"Click on Start Survey Tab", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"Click on Start Survey Tab", status);
		}}
		
		}
	
	
}
