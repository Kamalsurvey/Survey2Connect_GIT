package test.createsurvey;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import s2c.testbase.configTest;
import s2c.webpages.singleChoiceScreen;
import utilities.generateReport;

public class T5addQuestionsTest extends configTest{
	
	public static singleChoiceScreen singlechoicescreen;
	Logger testLogger;
	
	public T5addQuestionsTest()
	{testLogger=Logger.getLogger(T5addQuestionsTest.class);}
	
	
	@Test
	public void addSingleChoiceQuestion()
	{  try{
		testLogger.info("Clicking on Single Choice Test");
		singlechoicescreen=T4clickStartTabTest.getaddQuestiionsPage().addSingleChoice();
		
		if(singlechoicescreen==null){ throw new Exception();}
		else
		{testLogger.info("Single Choice screen clicked successfully");}
		
	}catch(Exception e){
		
		testLogger.info("User could not Click on Single Choice icon .");
		testLogger.error(e.getMessage());
		e.printStackTrace();
		Assert.fail();
	}
		
	}
	
	public static singleChoiceScreen getSingleChoiceSreen()
	{
		return singlechoicescreen;
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
		generateReport.addPassStatus(testcounter,"Click on Single Choice Icon", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"Click on Single Choice Icon", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"Click on Single Choice Icon", status);
		}}
		
		}
	
	

}
