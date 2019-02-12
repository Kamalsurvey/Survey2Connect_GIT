package test.createsurvey;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import s2c.testbase.configTest;
import s2c.webpages.NPSTilesHorizontalScreen;
import utilities.generateReport;

public class T10createNPSTilesHorizontal extends configTest {
	
	public T10createNPSTilesHorizontal(){		
		testLogger=Logger.getLogger(T10createNPSTilesHorizontal.class);
		}
	
	@Test
	public void enterMultiChoiceOption(){
	
		try{		
			testLogger.info("Creating NPS Question");
		    // T08enterMultiChoiceOptionsTest.getclickNPSIcon().clickNPSIcon();
			new NPSTilesHorizontalScreen().createNPS();
			
		   
		
	}catch(Exception e){

		testLogger.info("Problem occured while creating NPS Question.");
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

