package webTablesHandling;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GopiPagadala {
	@Test
	public void gp() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("----remote-allow-origins=*");
		driver=new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://app.hrone.cloud/login");
		 
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//input[@type='text']"));
		ele.sendKeys("9392038468");
		driver.findElement(By.xpath("//span[text()=' NEXT ']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Gopi@468");
	    driver.findElement(By.xpath("//span[text()=' LOG IN ']")).click();
	    Thread.sleep(3000);
//	  Actions act=new Actions(driver);
//	  act.moveByOffset(20, 20);
//	  driver.switchTo().alert().accept();
	   WebElement ele1 = driver.findElement(By.className("Inbox"));
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	  wait.until(ExpectedConditions.visibilityOf(ele1));
      ele1.click();
	}

}
