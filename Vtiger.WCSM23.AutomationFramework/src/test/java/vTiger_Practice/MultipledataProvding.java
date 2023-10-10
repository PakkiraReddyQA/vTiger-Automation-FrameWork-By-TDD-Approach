package vTiger_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import vTiger_genericutility.WebDriverUtility;

public class MultipledataProvding {
	
	@Test
	public void addtMultipleTasks()
	{
		WebDriverUtility wUtil=new WebDriverUtility();
		WebDriver driver=new FirefoxDriver();
		
		wUtil.waitforloadPage(driver);
		
		driver.get("https://demo.actitime.com/login.do");
		
		wUtil.maximize(driver);
		
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		
		driver.findElement(By.className("content tasks")).click();
		
		
	}

}
