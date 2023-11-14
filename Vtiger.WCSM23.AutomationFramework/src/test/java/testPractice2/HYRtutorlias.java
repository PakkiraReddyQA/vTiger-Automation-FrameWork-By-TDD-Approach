package testPractice2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HYRtutorlias {
	@Test
	void hyrtu() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.hyrtutorials.com/");
		Thread.sleep(2000);
		driver.findElement(By.className("down")).click();
//        Actions act=new Actions(driver);
//		
//		act.moveByOffset(10, 10).click().perform();
	}

}
