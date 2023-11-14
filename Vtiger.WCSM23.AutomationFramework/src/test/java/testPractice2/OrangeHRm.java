package testPractice2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import vTiger_genericutility.WebDriverUtility;

public class OrangeHRm {
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriverUtility wUtil=new WebDriverUtility();
	    WebDriver driver=new ChromeDriver();
	    wUtil.waitforloadPage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Leave']")).click();
		
		WebElement DpBox = driver.findElement(By.className("(//div[text()='-- Select --'])[1]"));
		Thread.sleep(2000);
		
		wUtil.mouseHoverAction(driver, DpBox);
		
		List<WebElement> DropBoxList = driver.findElements(By.xpath("//div[@role='listbox']"));
		Thread.sleep(1000);
		for(WebElement values:DropBoxList)
		{
			System.out.println(values.getText());
		}
		
		
	}

}
