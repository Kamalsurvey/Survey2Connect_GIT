package test.createsurvey;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import s2c.testbase.configTest;
import s2c.webpages.MultiChoiceSCreen;
import s2c.webpages.clickNPS;
import utilities.generateReport;

public class T08enterMultiChoiceOptionsTest  extends configTest{
	
	public static clickNPS clicknpsicon;
	
	public T08enterMultiChoiceOptionsTest(){		
		testLogger=Logger.getLogger(T08enterMultiChoiceOptionsTest.class);
		}
	
	
	@Test
	public void enterMultiChoiceOption(){
	
		try{		
			testLogger.info("Entering text into multi Choice Question");
		    clicknpsicon=T07clickMultiChoiceIconTest.getMultichoiceScreen().enterText();
		    if(clicknpsicon==null){}
		    else
		    {testLogger.info("Text entered successfully");}
		
	}catch(Exception e){

		testLogger.info("Problem occured while entering text in multi choice question .");
		testLogger.error(e.getMessage());
		e.printStackTrace();
		Assert.fail();
		
	}
	}
	
	public static clickNPS getclickNPSIcon()
	{
			return clicknpsicon ;
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
		generateReport.addPassStatus(testcounter,"Enter Text in Multi Choice Question", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"Enter Text in Multi Choice Question", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"Enter Text in Multi Choice Question", status);
		}}
		
		}

}
