package s2c.testbase;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.generateReport;

public class configTest {

	public static WebDriver driver ;
	public static Properties prop;
	public FileInputStream fis;
	public static Logger testLogger;
	public static WebDriverWait wait ;
	public static int testcounter;
	public String confirmation_message ;
		

	public configTest(){
		try{
			prop=new Properties();
			fis=new FileInputStream("C:\\Users\\ka.dhingra\\Survey2Connect\\Survey2Connect\\src\\main\\java\\s2c\\configurations\\config.properties");
			prop.load(fis);
			DOMConfigurator.configure("Log4j.xml");
			new generateReport().initialize();  // initialization of Report class
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Problem with properties file has been occured.");}
	}
	public static void initBrowser(String browserName){
		switch(browserName)
		{
		case "chrome" : 
		{
			System.setProperty("webdriver.chrome.driver","C://Users//ka.dhingra//Survey2Connect//Survey2Connect//Drivers//chromedriver.exe");
			driver=new ChromeDriver();
			wait=new WebDriverWait(driver,20);  // Wait by 20 sesc
			driver.manage().window().maximize();
		} break ;		

		case "firefox": 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ka.dhingra\\Survey2Connect\\Survey2Connect\\Drivers\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();	
			
			wait=new WebDriverWait(driver,20);  // Wait by 20 sesc
		} break;
		
		case "IE": 
		{
			System.setProperty("webdriver.ie.driver", "C://Users//ka.dhingra//Survey2Connect//Survey2Connect//Drivers//IEDriverServer_final.exe");
			driver=new InternetExplorerDriver();	
			
			wait=new WebDriverWait(driver,20);  // Wait by 20 sesc
		} break;

		default : driver=new HtmlUnitDriver();
		}		
	}

	public static WebDriver getDriver()
	{return driver;}


	public static void waitforElement(WebElement element){	
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitforElementClick(WebElement element){	
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitforElements(List list){	
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
	}

	public static void waitforElementBYXpath(By xpath){	
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		
		
		
		
	}
}
