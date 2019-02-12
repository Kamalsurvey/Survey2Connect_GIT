package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class generateReport {
	
	public static File report;
	public static FileWriter fw;
	public static BufferedWriter bw;

	public static void initialize() throws IOException
	{
		report=new File("C://Users//ka.dhingra//Survey2Connect//Survey2Connect//Reports//testReport.html");
		fw=new FileWriter(report);	
		bw=new BufferedWriter(fw);
	}
	
	public static void addHeader() throws IOException{
bw.write("<html><table border="+1+" <tr><td style='width:80px'> SN </td> <td style='width:150px'> TEST NAME </td><td style='width:120px'> TEST STATUS </td> </tr></table></html>");
}
	
	public static void close() throws IOException{
		bw.close();
		fw.close();
}
	
	public static void addPassStatus(int count,String MethodName , String status) throws IOException
	{
	
	bw.append("<html><table border="+1+"<tr><td style='width:80px'> "+count+" </td> <td style='width:150px'> "+MethodName+" </td><td bgcolor="+"#0bb62b"+" style='width:120px'> "+status+" </td> </tr></table></html>");
	}
	
	
	public static void addFailStatus(int count,String MethodName , String status) throws IOException
	{	
	bw.append("<html><table border="+1+"<tr><td style='width:80px'>"+count+" </td> <td style='width:150px'> "+MethodName+" </td><td bgcolor="+"#b60b0b"+" style='width:120px' > "+status+" </td> </tr></table></html>");
	}
	

	
}