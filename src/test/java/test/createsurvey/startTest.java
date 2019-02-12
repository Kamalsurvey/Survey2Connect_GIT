package test.createsurvey;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utilities.generateReport;
import utilities.readTestSheet;

public class startTest {
	
	  @BeforeSuite()
		public void setUp() throws IOException
		{
			initBrowser.init();
			readTestSheet.readTestMode();
	    	readTestSheet.getTestSheet();
		}
	@Test
	public void test1(){System.out.println("Test has been started");}
	
	 @AfterSuite
		public void closeReport() throws IOException
		{
	    	generateReport.close();
		}

}
