package test.createsurvey;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import s2c.testbase.configTest;
import s2c.webpages.clickMultiChoice;
import s2c.webpages.firstPage;
import s2c.webpages.singleChoiceScreen;
import utilities.generateReport;

public class T06enterSingleChoiceOptionsTest extends configTest {
	
	public static clickMultiChoice clickmultichoice;
	static Logger testLogger;
	
	public T06enterSingleChoiceOptionsTest(){		
		testLogger=Logger.getLogger(T06enterSingleChoiceOptionsTest.class);
		}
	

	@Test()
	public static void enterTextforSC(){
	    try{
	    	testLogger.info("Inserting text into Single Choice Question");
		    //  clickmultichoice = T5addQuestionsTest.getSingleChoiceSreen().enterText();
	    	
	    	// To run test from this page 
	    	
	    	clickmultichoice=	zTempTest.getSinglechoicescreen().enterText(); 
		    
		
		if(clickmultichoice==null){throw new Exception();}
		else{testLogger.info("Single choice question created successfully");}
	     }catch(Exception e){
		
	    		testLogger.info("Problem occured while entering text into single choice question .");
	    		testLogger.error(e.getMessage());
	    		e.printStackTrace();
	    		Assert.fail();
	    	 
	       }
	}
	    
	
	
	
	public static clickMultiChoice getMultiChoicePage()
	{return clickmultichoice ;}
	
	
	@AfterMethod
	public void setStatusintoReport(ITestResult result) throws IOException
	{
		testcounter++;
		String status=null;
		int i=result.getStatus();
		switch(i){
		case ITestResult.SUCCESS: 
		{status="PASS";
		generateReport.addPassStatus(testcounter,"Enter Text in Single Choice Question", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"Enter Text in Single Choice Question", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"Enter Text in Single Choice Question", status);
		}}
		
		}
}

//*********************Code to test page directly*****************
