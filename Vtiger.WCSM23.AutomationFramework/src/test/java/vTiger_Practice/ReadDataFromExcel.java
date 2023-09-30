package vTiger_Practice;

import java.io.FileInputStream;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadDataFromExcel {
public static void main(String[] args) throws Exception {
	//step1:load the file into file input stream-java readble format
	FileInputStream fis=new FileInputStream("src\\test\\resources\\TestData.xlsx");
	//step2:create workBook
	Workbook wb = WorkbookFactory.create(fis);
	//step3:Navigate to required sheet
	Sheet sh = wb.getSheet("sheet1");
	//step4:Navigate to the required row
	Row rw = sh.getRow(1);
	//Step5:Navigate to the required cell
	Cell c = rw.getCell(2);
	//Step6:Fetch the data from paricular cell to store variable
	String value = c.getStringCellValue();
	//step7: print the value in eclipose
	System.out.println(value);
	
	//String value1 = wb.getSheet("sheet").getRow(1).getCell(2).getStringCellValue();
	
}
}
