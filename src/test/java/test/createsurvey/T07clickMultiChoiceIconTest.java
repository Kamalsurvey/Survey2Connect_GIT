package test.createsurvey;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import s2c.testbase.configTest;
import s2c.webpages.MultiChoiceSCreen;
import utilities.generateReport;

public class T07clickMultiChoiceIconTest extends configTest {
	
	public static MultiChoiceSCreen multichoicescreen;
	static Logger testLogger;
	
	public T07clickMultiChoiceIconTest(){		
		testLogger=Logger.getLogger(T07clickMultiChoiceIconTest.class);
		}
	
	@Test
	public void clickMultiChoice()
	{
		try{
			testLogger.info("Clicking on Multi Choice Question");
			multichoicescreen=T06enterSingleChoiceOptionsTest.getMultiChoicePage().clickMultiChoice();
			if(multichoicescreen==null){throw new Exception();}
			else{testLogger.info("Multi Choice Question Clicked successfully");}
		}catch(Exception e){
			
			testLogger.info("Problem occured while clicking on Multi choice question .");
    		testLogger.error(e.getMessage());
    		e.printStackTrace();
    		Assert.fail();
			
		}
	}
	
	public static MultiChoiceSCreen getMultichoiceScreen()
	{
			return multichoicescreen;
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
		generateReport.addPassStatus(testcounter,"Click on multi choice Question", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"Click on multi choice Question", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"Click on multi choice Question", status);
		}}
		
		}

}
