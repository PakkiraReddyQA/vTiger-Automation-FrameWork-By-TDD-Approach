package vTiger_Practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static void main(String[] args) throws Exception {
		//Steo1:Read the file in java readble format using fileinpputstream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//Step2:create object of properties class
		Properties pos=new Properties();
		//Step3:Load the fileinputstream
		pos.load(fis);
		//Step4:provide the key and read the value
		String URL = pos.getProperty("url");
		
		System.out.println(URL);
		
		String USERNAME = pos.getProperty("username");
		System.out.println(USERNAME);
		
		String BROWSER = pos.getProperty("browser");
		System.out.println(BROWSER);
	}

}
