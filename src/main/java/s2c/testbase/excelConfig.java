package s2c.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excelConfig {
    
	public static  File file ;
	public static FileInputStream fis;    
	public static  String sheet_runmode="C:\\Users\\ka.dhingra\\Survey2Connect\\Survey2Connect\\TEST_SHEET.xls";
	public static HSSFWorkbook workbook;
	public static HSSFSheet worksheet;
	public static HSSFRow row;
	public static HSSFCell cell;
	public static List runnabletest;

}
