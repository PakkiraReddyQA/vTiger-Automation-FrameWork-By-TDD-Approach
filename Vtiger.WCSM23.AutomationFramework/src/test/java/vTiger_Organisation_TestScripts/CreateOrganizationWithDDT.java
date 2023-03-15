package vTiger_Organisation_TestScripts;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger_genericutility.Iconstant;
@Listeners(vTiger_genericutility.ListenersImplementaionClass.class)
public class CreateOrganizationWithDDT {
	@Test
	public void ddt() throws Exception {
		Random r=new Random();
		int random = r.nextInt();
		
		//Step1:read the data from property file
		FileInputStream fisp=new FileInputStream(Iconstant.PropertyFilePath);
		Properties posp=new Properties();
		posp.load(fisp);
		String USERNAME = posp.getProperty("username");
		String PASSWORD = posp.getProperty("password");
		String URL = posp.getProperty("url");
		String BROWSER = posp.getProperty("browser");
		
		
		/* Read the data from excel sheet that test data*/
		
		FileInputStream foie=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				Workbook wb = WorkbookFactory.create(foie);
		 String OrgName = wb.getSheet("Organization").getRow(4).getCell(2).getStringCellValue()+random;
		
		 //step2:Launch the browser
		 WebDriver driver=null;
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 ChromeOptions options=new ChromeOptions();
			 options.addArguments("--remote-allow-origins=*");
			 driver=new ChromeDriver(options);
		 }
		 else if(BROWSER.equalsIgnoreCase("FireFox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		 }
		 else
		 {
			 System.out.println("invaild browser name");
		 }
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get(URL);
		 //Step3:login to application
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		 
		 //step4:click on organization link
		 driver.findElement(By.linkText("Organizations")).click();
		 
		 //step4:click on org name lookup icon
		 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 
		 //step5:provide org name in org text box
		 
		 driver.findElement(By.name("accountname")).sendKeys(OrgName);
		 
		 //step6:save
		 
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 //step7:validate
		 String element = driver.findElement(By.className("dvHeaderText")).getText();
		 if(element.contains(OrgName))
		 {
			 System.out.println("passed");
		 }
		 else {
			 System.out.println("failed");
		 }
		 //step8:logout
		 
		 WebElement element2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(element2).perform();
		 driver.findElement(By.linkText("Sign Out")).click();
	}

}
