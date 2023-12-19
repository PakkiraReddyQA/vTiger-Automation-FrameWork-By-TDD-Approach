package testPractice2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HrOneLogin {
	@Test
	void hrone() throws Exception
	{
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		
        
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://app.hrone.cloud/login");
		Thread.sleep(1000);
		
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		act.moveByOffset(30,30).click().perform();
		
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("9618456544");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@data-style='expand-left'])[1]")).click();
		Thread.sleep(2000);
        driver.findElement(By.id("hrone-password")).sendKeys("Pakki@123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()=' LOG IN ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//em[text()=' clear ']")).click();

        
        driver.findElement(By.className("material-icons")).click();
        Thread.sleep(2000);
//        Actions act=new Actions(driver);
//        act.moveByOffset(20, 20).click().perform();
        
       
        
        driver.findElement(By.className("avatar-content ng-star-inserted")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("cls-submenu")).click();
        driver.close();
	}

}
