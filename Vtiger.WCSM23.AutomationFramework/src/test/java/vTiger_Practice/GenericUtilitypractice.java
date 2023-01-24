package vTiger_Practice;

import vTiger_genericutility.ExcelFileUtility;
import vTiger_genericutility.JavaUtility;
import vTiger_genericutility.PropertiesFileUtility;
import vTiger_genericutility.WebDriverUtility;

public class GenericUtilitypractice {
	
	public static void main(String[] args) throws Exception 
	{
		
		JavaUtility ju = new JavaUtility();
		int data = ju.getRandomNumber();
		System.out.println(data);
		
		String date = ju.getSystemDate();
		System.out.println(date);
		
		String d = ju.getSystemDateformat();
		System.out.println(d);
		
	PropertiesFileUtility putil=new PropertiesFileUtility();
	String value = putil.readDataFromPropertyFile("browser");
	System.out.println(value);
	System.out.println(putil.readDataFromPropertyFile("url"));
		
	
	ExcelFileUtility eft=new ExcelFileUtility();
	String value1 = eft.readDatafromExcel("contacts", 1, 2);
	System.out.println(value1);
	
	int rowCount = eft.getRowCount("contacts");
	System.out.println(rowCount);
	
	}
	
}
