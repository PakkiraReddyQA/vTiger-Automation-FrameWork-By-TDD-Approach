package vTiger_Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import vTiger_genericutility.ExcelFileUtility;

public class readdat {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelFileUtility eUtil=new ExcelFileUtility();
		Object[][] readData = eUtil.readmultipleDatafromExcel("multipleOrgs");
		
	}

}
