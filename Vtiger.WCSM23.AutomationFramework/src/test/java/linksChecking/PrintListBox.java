package linksChecking;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrintListBox {
	@Test
	void amazon() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.com/");
	driver.findElement(By.name("url")).click();
	Thread.sleep(2000);
 List<WebElement> DropBox = driver.findElements(By.xpath("//option[contains(@value,'search')]"));
	
	for(WebElement k:DropBox)
	{
		String values = k.getText();
		System.out.println(values);
	
	}
	}
	
	@Test
	void ama() throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung");
		 List<WebElement> Serch = driver.findElements(By.className("two-pane-results-container"));
		 Thread.sleep(1000);
		 for( WebElement sk:Serch)
		 {
		System.out.println(sk.getText());
		 }
		 driver.close();
		
	}

}
