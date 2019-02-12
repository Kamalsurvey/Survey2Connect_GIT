package test.createsurvey;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import s2c.testbase.configTest;
import s2c.webpages.firstPage;
import s2c.webpages.homePage;
import s2c.webpages.loginPage;
import utilities.generateReport;

public class T1loginTest extends configTest {

	public firstPage firstpage;
	public loginPage loginpage;
	public static homePage homepage;
	Logger testLogger;


	public T1loginTest(){
		super();
		testLogger=Logger.getLogger(T1loginTest.class);
	}

	@BeforeSuite
	public void setUP() throws IOException
	{
		configTest.initBrowser("firefox");
		firstpage=new firstPage();		               // initialize first Page
		driver.get(prop.getProperty("url"));
		generateReport.initialize();
		generateReport.addHeader();
	}

	@Test
	public  void executeLogin() throws InterruptedException
	{
		try{
			testLogger.info("Login Test Started");
			loginpage=firstpage.clickOnLogin();		

			if(loginpage==null){ 
					
				testLogger.error("Login Test could not be proceeded as Link could not clicked. ");
				testLogger.info("Login Test Failed");
				Assert.fail();
			}

			else {
				homepage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

				if(homepage!=null){
					testLogger.info("Login Test Succeeded Successfully");

				}
				else {					
					
					testLogger.info("Login test Failed");
					Assert.fail();
				}
			}
		}
		catch(Exception e)
		{

			testLogger.info("Login test Failed");
			testLogger.error(e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}	

	}


	public static homePage gethomePage(){return homepage;}


	//*************Insert Status into Report***************	


	@AfterClass
	public void setStatusintoReport(ITestResult result) throws IOException
	{
		testcounter++;
		String status=null;
		int i=result.getStatus();
		switch(i){
		case ITestResult.SUCCESS: 
		{status="PASS";
		generateReport.addPassStatus(testcounter,"Login Test", status);}
		break;
		case ITestResult.FAILURE:
		{status="FAIL";
		generateReport.addFailStatus(testcounter,"Login Test", status);}
		break;
		case ITestResult.SKIP: 
		{status="SKIPPED";
		generateReport.addFailStatus(testcounter,"Login Test", status);
		}
		}



		
		
		}
    @AfterSuite
	public void closeReport() throws IOException
	{
    	generateReport.close();
	}

}