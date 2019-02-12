package test.createsurvey;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import s2c.testbase.configTest;

public class logBug extends configTest {
	
	@Test
	public static void raiseBug() throws InterruptedException
	{
		String s=driver.getCurrentUrl();
		WebElement x=driver.findElement(By.xpath("//body"));
		Actions action=new Actions(driver);
	   Keys.chord(Keys.CONTROL+"t");
		x.sendKeys(Keys.CONTROL+"t");
	   Set set= driver.getWindowHandles();
	   System.out.println(("Set"+set.size()));
		driver.get("https://app.asana.com/-/login");
		driver.findElement(By.xpath("//input[@id='email_input']")).sendKeys("kamal@survey2connect.com");
		driver.findElement(By.xpath("//input[@id='password_input']")).sendKeys("kamal123@");
		driver.findElement(By.xpath("//button[@id='submit_button']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[@class='SidebarFavoritesAndMore-favorites']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[contains(@class,'GridHeader-buttons PotGridHeader-buttons')]/div[1]"));
		
	
		action.sendKeys("KAMAL").perform();
		
		Thread.sleep(5000);
		
		driver.get(s);
		
		
		
	}
	
	

}
