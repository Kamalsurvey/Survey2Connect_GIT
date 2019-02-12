package test.createsurvey;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import s2c.testbase.configTest;
import s2c.webpages.createSurveyScreen;
import s2c.webpages.homePage;
import utilities.generateReport;

public class T2CreateSurveyTest extends configTest {

	public static createSurveyScreen createsurveyscreen;
	public static homePage homepage;
	Logger testLogger;

	public T2CreateSurveyTest()
	{testLogger=Logger.getLogger(T2CreateSurveyTest.class);}

	@Test
	public void clickOnCreateSurveyTab()
	{ 
		try{
			if(T1loginTest.gethomePage()==null){
				homepage=new homePage();
			}
			else
				{homepage=T1loginTest.gethomePage();}
			
			testLogger.info("Create Survey link is being clicked");
			createsurveyscreen=T1loginTest.gethomePage().clickOnCreateSurvey();
			testLogger.info("Create Survey link clicked successfully");
			
		}
		catch(Exception e){ 

			testLogger.info("Create Survey Link could not be clicked.");
			testLogger.error(e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}

	}
	public static createSurveyScreen  getCreateSurveyScreen()
	{return createsurveyscreen;}

	@AfterMethod
	public void setStatusintoReport(ITestResult result) throws IOException
	{
		testcounter++;
		String status=null;
		int i=result.getStatus();
		switch(i){
		case ITestResult.SUCCESS: 
		{status="PASS";
		generateReport.addPassStatus(testcounter,"Click On Create Survey", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"Click On Create Survey", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"Click On Create Survey", status);
		}}
		
		}

}
