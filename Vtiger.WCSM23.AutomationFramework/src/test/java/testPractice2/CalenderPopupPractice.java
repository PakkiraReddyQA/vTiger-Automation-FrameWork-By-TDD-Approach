package testPractice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CalenderPopupPractice {
	@Test
	public void calanderPopup() throws InterruptedException
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.moveByOffset(20, 20).click().perform();
		
		WebElement srcCity = driver.findElement(By.id("fromCity"));
		WebElement toCity = driver.findElement(By.id("toCity"));
		
		srcCity.sendKeys("Mumbai");
		
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		
		toCity.sendKeys("Chennai");
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();
		Thread.sleep(3000);
	
		WebElement dep = driver.findElement(By.xpath("//label[@for='departure']"));
		dep.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(dep));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='Wed Jul 19 2023']")).click();
		
	}
	@Test
	void jdbc() throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "root");
		
		Statement sta = con.createStatement();
		
		ResultSet result = sta.executeQuery("select * from emp;");
		
		while(result.next())
		{
		System.out.println(result.getString(1)+" "+result.getString(2));
		}
		
	}
	
	
	

}
