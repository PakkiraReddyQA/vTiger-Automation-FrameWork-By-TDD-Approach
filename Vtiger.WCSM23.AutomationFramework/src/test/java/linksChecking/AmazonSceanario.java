package linksChecking;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSceanario {
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='hm-icon-label']")).click();
		List<WebElement> Headers = driver.findElements(By.xpath("//span[@class='hm-icon-label']"));
		for(int i=1;i<Headers.size();i++)
		{
			String va = Headers.get(i).getText();
			System.out.println(va);
//			if(va.contains("digital content & devices"));
//			{
//				
//			}
			driver.close();
		}
		
	}

}
