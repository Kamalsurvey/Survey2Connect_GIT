package updateQuestionType;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Test;

import s2c.objects.AddQuestionObjects;
import s2c.testbase.configTest;
import s2c.testbase.excelConfig;

public class fromSingleChoiceToOther extends configTest {

	Logger testLogger;
	ITestResult result;	

	//@BeforeClass
	public void checkRUnMode()	{
		if(!excelConfig.runnabletest.contains("fromSingleChoiceToOther")){throw new SkipException("");}		
	}

	
	
	
	public fromSingleChoiceToOther(){
		new configTest().initBrowser("chrome");
		driver=configTest.getDriver();
	    testLogger=Logger.getLogger(fromSingleChoiceToOther.class);
	}

	@Test
	public void changeType() throws InterruptedException{
		 driver.manage().deleteAllCookies();		
		driver.get("https://survey2connect.com");
		
	
		
			driver.manage().addCookie(new Cookie("survey" ,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1YzQ4NjA3MzNlNDAwMDNmMTE5MmU0ZmIiLCJzVGltZSI6MTU0ODY2OTA5NTg1MSwiaWF0IjoxNTQ4NjY5MDk1fQ.MBQe77VCVZz0Adg6HUzHVwDBf_GBJocW3VjR-RDNVSU" ));
			driver.manage().addCookie(new Cookie("s2c-session" ,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzVG9rZW4iOiI3Zjk0OWYzMiIsInNUaW1lIjoxNTQ4NjY5MDk1ODUxLCJpYXQiOjE1NDg2NjkwOTV9.qdAjadWyogt2Oy5txoKZpTPy6Flp1OuL2pKP7Rmn6gI" ));
			driver.get("https://design.survey2connect.com/surveyEdit/design/5c4eb665f6ad36787771f703/questions");
			Thread.sleep(5000);
			WebElement surveyFlow=driver.findElement(By.xpath("//div[@class='survey_flow_content']//ul[@class='sur_flow_ques_ul']//span[@title='Single Choice Question']"));
			surveyFlow.click();
			Thread.sleep(1000);
		int i=2;
		while(i<=19){
			
			if(i==2 || i==4 || i==6 || i==7 || i==8 || i==12 || i==13 || i==19){
			Thread.sleep(3000);
			WebElement editLink=driver.findElement(By.xpath("//div[@id='5c4ed873f6ad36787771fb01']/div[@class='question_actions']//div[@class='ques_actions_icon'][1]"));
			editLink.click();			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[contains(@class,'dropdown-toggle')]")).click();
			Thread.sleep(3000);			
           driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li["+i+"]/a")).click();			
			Thread.sleep(2000);
			String questiontype1=driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[2]/a/span/following-sibling::span")).getText();	
			
		System.out.println(questiontype1);
			
			
			System.out.println("Text is"+questiontype1);
			driver.findElement(By.xpath("//div[contains(@class,'left_sidebar_footer')]"));			
			driver.findElement(By.xpath("//div[contains(@class,'left_sidebar_footer')]/button[1]")).click();
			
			waitforElementBYXpath(By.xpath("//div[@class='toast-message']"));                  // verify confirmation Message
			confirmation_message=driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			
			testLogger.info("Question has been changed to "+questiontype1+" successfully");
			i++;
				
		
			
		}  // outer IF	
			
			else {i++;
			continue;}
			
	} // end of while
	 }}




