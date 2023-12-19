package responsiveED;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import vTiger.ObjectReposotary.DropDowns;
import vTiger_genericutility.PropertiesFileUtility;

public class DropDownsHandle {
	@Test
	void createQ() throws Exception
	{
		
		//Read the Common DataFrom Properties file.
		PropertiesFileUtility pUtil=new PropertiesFileUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
	
		
		driver.findElement(By.id("mat-input-0")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(PASSWORD);
		
		driver.findElement(By.xpath("//span[text()=' Sign In ']")).click();
		
		Thread.sleep(3000);
		DropDowns dwn=new DropDowns(driver);
		Thread.sleep(2000);
		dwn.UsersDropDwnHandle(driver,"demoschools");
		

}
}
