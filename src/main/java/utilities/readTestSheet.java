package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

import s2c.testbase.excelConfig;

public class readTestSheet extends excelConfig{
	public static int rowcount;
	public static int cellcount;
	public static String text;
	public static String testlist[][];
	

	
	public static void readTestMode() throws IOException{

		try{

			file=new File(sheet_runmode);
			fis=new FileInputStream(file);
			workbook=new HSSFWorkbook(fis);
			worksheet=workbook.getSheet("runmode");
			rowcount=worksheet.getLastRowNum();

			testlist=new String[rowcount+1][4];				
			for(int i=1;i<rowcount+1;i++){
				row=worksheet.getRow(i);
				cellcount=row.getLastCellNum();
				for(int j=0;j<cellcount;j++){
					cell=row.getCell(j);
					if(cell.getCellType()==cell.getCellType().STRING){					
						testlist[i][j]= cell.getStringCellValue().toString();	
						System.out.print(testlist[i][j]+" ");
					}
					else if(cell.getCellType()==cell.getCellType().NUMERIC){					
						Double text1=  cell.getNumericCellValue();
						testlist[i][j]= text1.toString();
						System.out.print(testlist[i][j]+" ");
					}
					else throw new Exception("Sheet has encountered an Invalid Data Type");
				}
				System.out.println();
			}

		} catch(Exception e){}		
	}

	
	public static void getTestSheet(){
		runnabletest=new ArrayList();
		for(int i=1;i<testlist.length;i++){
			if(testlist[i][3].equals("Y")){
				runnabletest.add(testlist[i][2]);
			}
		}

		java.util.Iterator itr=runnabletest.iterator();
		while(itr.hasNext()){System.out.println(itr.next());}

	}

}
