package vTiger_Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import vTiger_genericutility.Iconstant;

public class ExcelRelatedPractice {
	@Test
	public void readDataexcelsheet() throws EncryptedDocumentException, IOException
	{	
	FileInputStream fis=new FileInputStream(Iconstant.ExcelSheetFilepath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Organization");
	String value = sh.getRow(4).getCell(3).getStringCellValue();
	System.out.println(value);
	}
	public void writeDataIntoExcel() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(Iconstant.ExcelSheetFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Organization");
		Row rw = sh.createRow(4);
		Cell ce = rw.createCell(5);
	      ce.setCellValue("wipro");
	      FileOutputStream fos=new FileOutputStream(Iconstant.ExcelSheetFilepath);
	      wb.write(fos);
		
	}
	
	
}
