package vTiger_contacts_TestScripts;

import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger_genericutility.ExcelFileUtility;
import vTiger_genericutility.JavaUtility;
import vTiger_genericutility.PropertiesFileUtility;
import vTiger_genericutility.WebDriverUtility;
@Listeners(vTiger_genericutility.ListenersImplementaionClass.class)
public class CreateContacts {
	@Test
	public void createcontactTest() throws Exception {
		
		WebDriverUtility wUtil=new WebDriverUtility();
		PropertiesFileUtility pUtil=new PropertiesFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		JavaUtility jUtil=new JavaUtility();
		jUtil.getRandomNumber();
		
		/*read data from property file */
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		String lastname = eUtil.readDatafromExcel("contacts", 1, 2);
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		//Launch browser
		wUtil.waitforloadPage(driver);
		driver.get(URL);
		wUtil.maximize(driver);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//click on contacts link
		driver.findElement(By.linkText("Contacts")).click();
		//click on contact look up icon
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//// Step5:create Contact with mandatory fields
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname)
		;
		// Step6:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// Step7:validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (contactHeader.contains("chaitra")) {
			System.out.println(contactHeader);
			System.out.println("Pass");
		} else
			System.out.println("Fail");
	}
	}


