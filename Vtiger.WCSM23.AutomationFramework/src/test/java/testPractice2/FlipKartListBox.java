package testPractice2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FlipKartListBox {
	@Test
	void PrintMotreLstBox() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		
        
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		Thread.sleep(1000);
		
		Actions act=new Actions(driver);
		
		act.moveByOffset(10,10).click().perform();
		driver.findElement(By.xpath("//img[@alt='Beauty']")).click();
		
		WebElement More = driver.findElement(By.xpath("//div[text()='More']"));
		System.out.println(More.getText());
		
		act.moveToElement(More).perform();
		
		Thread.sleep(2000);
		List<WebElement> moreListBoxItems = driver.findElements(By.xpath("//a[@class='_2kxeIr']"));
		for(WebElement k:moreListBoxItems)
		{
			System.out.println(k.getText());
		}
		driver.close();
	}
	@Test
	void flp() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		//driver.manage().window().minimize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//span[@class='_30XB9F']")).click();
		WebElement ele=driver.findElement(By.xpath("//img[@class='_2puWtW _3a3qyb']"));
		Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
		
	WebElement ele1=	driver.findElement(By.xpath("//div[@class='exehdJ']"));
	System.out.println(ele1.getText());
	//Actions act1=new Actions(driver);
	act.moveToElement(ele1).perform();
	
	Thread.sleep(2000);
	List<WebElement> l=	driver.findElements(By.xpath("//a[@class='_2kxeIr']"));
	for(int i=0;i<l.size();i++)
	{
		String s=l.get(i).getText();
		System.out.println(s);
	}
	
		
	}
}
