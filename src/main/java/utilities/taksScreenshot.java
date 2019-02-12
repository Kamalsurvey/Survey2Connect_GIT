package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class taksScreenshot {
	
	
public void captureScreenOnFailure(WebDriver driver) throws IOException{
	
	TakesScreenshot screen=((TakesScreenshot)driver);
	File screenshot=screen.getScreenshotAs(OutputType.FILE);	
	File file=new File("");
	FileUtils.copyFile(screenshot, file);
	
}


public void captureScreenOnSuccess(){
	
}

}
