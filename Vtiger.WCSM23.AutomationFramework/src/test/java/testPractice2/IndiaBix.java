package testPractice2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IndiaBix {
	
	public static void main(String[] args) 
	{
	
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.indiabix.com/");
		
		driver.findElement(By.xpath("//a[text()='Arithmetic Aptitude']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Problems on Trains']")).click();
		
//		WebElement QNo = driver.findElement(By.xpath("//div[@class='bix-td-qno']"));
		Actions act=new Actions(driver);
//		act.moveByOffset(10, 10).perform();
		act.doubleClick().perform();
		
//		driver.switchTo().alert().dismiss();
		
       
        	driver.findElement(By.id("lnkOptionLink_A_454")).click();
        
        driver.close();
	}

}
