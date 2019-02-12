package test.createsurvey;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import s2c.testbase.configTest;

public class initBrowser extends configTest {
	
	public static void init(){
		
		  configTest.initBrowser("chrome");
	     configTest.getDriver().get("https://www.survey2connect.com");
		
		Cookie c1=new Cookie("survey","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1YzQ4NjA3MzNlNDAwMDNmMTE5MmU0ZmIiLCJzVGltZSI6MTU0ODI0NzI0NTk1NywiaWF0IjoxNTQ4MjQ3MjQ1fQ.I2pvy6tuYoApNbWSWZQDy-5fTeL43wLW3Q5aeO4MwdA");
		Cookie c2=new Cookie("s2c-session","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzVG9rZW4iOiI5YTY5NzlkNyIsInNUaW1lIjoxNTQ4MjQ3MjQ1OTU3LCJpYXQiOjE1NDgyNDcyNDV9.t-0hYH2dmN0XslcyWrozuKYud6e8IkYkwGr-Cv2Yspw");
		driver.manage().addCookie(c1);
		driver.manage().addCookie(c2);
		driver.get("https://design.survey2connect.com/surveyEdit/design/5c4860e6ca8b303f34252254/questions");
		waitforElementBYXpath(By.xpath("//div[@class='question_footer_btns'][1]/button[@title='Add Question']"));
		WebElement plusIcon=driver.findElement(By.xpath("//div[@class='question_footer_btns'][1]/button[@title='Add Question']"));
		
		plusIcon.click();
		System.out.println("+ has been clicked");
		//Thread.sleep(5000L);
		
	}

}
