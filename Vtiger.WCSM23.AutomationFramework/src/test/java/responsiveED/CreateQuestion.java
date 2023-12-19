package responsiveED;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger_genericutility.PropertiesFileUtility;

public class CreateQuestion 
{
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
		//Click on Application Question
		driver.findElement(By.xpath("//span[text()='Application Questions']")).click();
		//Click on GO Button
		driver.findElement(By.xpath("//span[text()='Go']")).click();
		//Create Button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Create']")).click();
		// Enter question
		driver.findElement(By.name("question")).sendKeys("are you automation tester?");

		 //Click type DropDown
		driver.findElement(By.xpath("//mat-label[text()='select']")).click();
		Thread.sleep(3000);
		//Choose the Value from Type DropDown
		String DropDownValue="Radio";
		driver.findElement(By.xpath("//span[text()='"+DropDownValue+"']")).click();
		Thread.sleep(3000);
	     //Enter the Answer
		driver.findElement(By.xpath("//input[@id='answer0']")).sendKeys("yes");
		//Click Add Button----> Question Gets Created.
//		driver.findElement(By.xpath("//span[text()='Add']")).click();
	}
}
