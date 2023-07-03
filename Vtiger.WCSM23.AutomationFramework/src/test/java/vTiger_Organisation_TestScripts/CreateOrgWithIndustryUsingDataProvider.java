package vTiger_Organisation_TestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustryUsingDataProvider {
	@Test(dataProvider = "getData")
	public void createOrgWithInd(String ORGNAME,String INDUSTRY) throws IOException, InterruptedException
	{
		//Read the data from Excel propertyFile
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pos=new Properties();
		pos.load(fis);
		String BROWSER = pos.getProperty("browser");
		String URL = pos.getProperty("url");
		String USERNAME = pos.getProperty("username");
		String PASSWORD = pos.getProperty("password");
		
		WebDriver driver=null;
		if(BROWSER.contains("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		}
		else if(BROWSER.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser Name Found");
		}
		//Launch the Browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.manage().window().maximize();
		//Step1:Login to the Application
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();
        //Step2:Navigate to the Orgnization link
        driver.findElement(By.linkText("Organizations")).click();
        //Step3:Navigate to the Create New org img link
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        //Step4:Provide the org name in the org text box
        driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
        Thread.sleep(3000);
        //Step5:Provide the Industry dropdown
        driver.findElement(By.name("industry")).sendKeys(INDUSTRY);
        //Save
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        Thread.sleep(3000);
        driver.quit();
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[5][2];
		Random r=new Random();
		int random = r.nextInt();
		
		data[0][0]="Wipro"+random;
		data[0][1]="Energy";
		
		data[1][0]="Infosys"+random;
		data[1][1]="Finance";
		
		data[2][0]="Sapphirus"+random;
		data[2][1]="Education";
		
		data[3][0]="Abc"+random;
		data[3][1]="Healthcare";
		
		data[4][0]="viki"+random;
		data[4][1]="Insurance";
		
		return data;
		
		
	}

		         

}
