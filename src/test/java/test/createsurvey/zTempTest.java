package test.createsurvey;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import s2c.testbase.configTest;
import s2c.webpages.singleChoiceScreen;
import utilities.generateReport;

public class zTempTest {
	
	public static singleChoiceScreen singlechoicescreen;
	
	@Test
	public void tempTest() throws Exception
	{
		configTest.initBrowser("firefox");	      
		generateReport.initialize();
		generateReport.addHeader();
		configTest.getDriver().get("https://survey2connect.com/login");
		Cookie c1=new Cookie("survey","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1OTM5MzQ2ZjQ3Y2FiZmI3NTM2MWU0MzEiLCJzVGltZSI6MTU0Mzk5ODcxNTE4OSwiaWF0IjoxNTQzOTk4NzE1fQ.xBRfQOv8x5l38dYC3Da_3PtHzGzt77WNdCd5hZXfveU");
		Cookie c2=new Cookie("s2c-session","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzVG9rZW4iOiJjMDVmMjVmMiIsInNUaW1lIjoxNTQzOTk4NzE1MTg5LCJpYXQiOjE1NDM5OTg3MTV9.HlTSThYhtGqbmf_-QqSJNvNxGWBK9wd39KU1AiEQxOI");
		configTest.getDriver().manage().addCookie(c1);
		configTest.getDriver().manage().addCookie(c2);
		configTest.getDriver().get("https://design.survey2connect.com/surveyEdit/design/5c078b1468529657bda6f569/questions");
		configTest.getDriver().findElement(By.xpath("//div[@class='question_footer_btns'][1]/button[@title='Add Question']")).click();
		Thread.sleep(5000L);
		//configTest.getDriver().findElement(By.xpath("//div[@class='ques_types_row'][1]/div[@class='ques_types'][1]")).click();	 //SC
		configTest.getDriver().findElement(By.xpath("//div[@class='ques_types_row'][1]/div[@class='ques_types'][3]")).click();	 //NPS
		
		WebDriverWait wait=new WebDriverWait(configTest.getDriver(),20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
		System.out.println("Done");
		
		WebElement e1=configTest.getDriver().findElement(By.xpath("//iframe"));
		System.out.println(e1.getAttribute("id"));
		String s1=e1.getAttribute("id");
		
	configTest.getDriver().switchTo().frame(e1);
	
	configTest.getDriver().findElement(By.xpath("//body[@id='tinymce']")).sendKeys("KAMAL");
	
	configTest.getDriver().switchTo().defaultContent();
	
	WebElement e3=configTest.getDriver().findElement(By.xpath("//div[@class='nps_options']//select"));
	System.out.println("Done3");
	Select select=new Select(e3);
	
	//select.selectByValue("Tiles (Vertical)");
	select.selectByVisibleText("Tiles (Vertical)");
	select.selectByIndex(3);
	List l=configTest.getDriver().findElements(By.xpath("//span[@class='custom_radio_grp']//span"));
	Iterator c=l.iterator();
	while(c.hasNext())
	{
		WebElement x=(WebElement)c.next();
		System.out.println(x.getText());
	if(x.getText().equals(("No Color") )){x.click();
	
	}
	}
	
	System.out.println("Done2");
	
	configTest.getDriver().findElement(By.xpath("//div[@class='left_sidebar_footer']/button[1]")).click();
		
		
		
		
		
		
		
		
		//singlechoicescreen=new singleChoiceScreen();		
		}
 
	public static singleChoiceScreen getSinglechoicescreen()
	{
		return singlechoicescreen;
	}
	
	@AfterSuite
	public void closeReport() throws IOException
	{
    	generateReport.close();
	}
 


}
