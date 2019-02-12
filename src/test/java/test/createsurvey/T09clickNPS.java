package test.createsurvey;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import s2c.testbase.configTest;
import utilities.generateReport;

public class T09clickNPS extends configTest {
	
	public T09clickNPS(){		
		testLogger=Logger.getLogger(T09clickNPS.class);
		}
	
	@Test
	public void enterMultiChoiceOption(){
	
		try{		
			testLogger.info("Clicking on NPS Question");
		     T08enterMultiChoiceOptionsTest.getclickNPSIcon().clickNPSIcon();
		   
		
	}catch(Exception e){

		testLogger.info("Problem occured while clicking on NPS .");
		testLogger.error(e.getMessage());
		e.printStackTrace();
		Assert.fail();
		
	}
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
		generateReport.addPassStatus(testcounter,"Clicking NPS Icon", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"Clicking NPS Icon", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"Clicking NPS Icon", status);
		}}
		
		}
	
	

}
