package test.createsurvey;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import s2c.testbase.configTest;
import s2c.webpages.createSurveyScreen;
import s2c.webpages.startButtonPage;
import utilities.generateReport;

public class T3startFromScratchTest extends configTest {

	public static startButtonPage startbuttonpage;
	public static createSurveyScreen createsurveyscreen;
	Logger testLogger;

	public T3startFromScratchTest()
	{testLogger=Logger.getLogger(T3startFromScratchTest.class);}

	@Test	
	public  void enterSurveyNamAndCreate()
	{ try{
		testLogger.info("User is entering survey Name");
		createsurveyscreen=T2CreateSurveyTest.getCreateSurveyScreen();	 
		startbuttonpage=createsurveyscreen.enterSurveyName();
		testLogger.info("Survey has been created successfully");

		
	} catch(Exception e){
		
		testLogger.info("User could not enter Name  of the Survey .");
		testLogger.error(e.getMessage());
		e.printStackTrace();
		Assert.fail();
		
	}
	}


	public static startButtonPage getstartButtonPage()
	{
		return  startbuttonpage;
	}

	@AfterMethod
	public void setStatusintoReport(ITestResult result) throws IOException
	{
		testcounter++;
		String status=null;
		int i=result.getStatus();
		switch(i){
		case ITestResult.SUCCESS: 
		{status="PASS";
		generateReport.addPassStatus(testcounter,"Enter Survey Name and Submit", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"Enter Survey Name and Submit", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"Enter Survey Name and Submit", status);
		}}
		
		}

}







