package TestPackage;

import java.io.IOException;

import org.testng.annotations.Test;

import utilities.readTestSheet;

public class tryClass {
	
	@Test
	public void test1() throws IOException
	{
		readTestSheet s=new readTestSheet();
		s.readTestMode();
		
	}

}
