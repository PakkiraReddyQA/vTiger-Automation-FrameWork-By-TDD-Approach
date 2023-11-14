package testPractice2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class W3Schools1 {
	
	
	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.w3schools.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	List<WebElement> h = driver.findElements(By.xpath("//a[@class='ga-nav']"));
	
	for(int i=0;i<h.size();i++)
	{
		int count=1;
		String title=h.get(i).getText();
		if(title.equalsIgnoreCase("sql"))
		{
			h.get(i).click();

			driver.findElement(By.xpath("//a[normalize-space()='Start SQL Quiz!']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[contains(text(),'Start the SQL Quiz ❯')]")).click();
			for(int j=1;j<=25;j++)
			{
				WebElement select = driver.findElement(By.xpath("//label[@id='label2']"));
				WebElement next = driver.findElement(By.xpath("//button[contains(text(),'Next ❯')]"));
				if(select.isDisplayed())
				{
					select.click();
					next.click();
					Thread.sleep(1000);
				}
			}
			WebElement ee =driver.findElement(By.xpath("//div[@class='w3-large']"));
			String s=ee.getText();
			System.out.println("SQL RESULT");
			System.out.println(s); 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[normalize-space()='Quiz Python']")).click();
			Thread.sleep(2000);
			for(int kk=1;kk<=25;kk++)
			{
				WebElement select = driver.findElement(By.xpath("//label[@id='label2']"));
				WebElement next = driver.findElement(By.xpath("//button[contains(text(),'Next ❯')]"));
				if(select.isDisplayed())
				{
					select.click();
					next.click();
					Thread.sleep(1000);
				}	
			}
			WebElement e3 =driver.findElement(By.xpath("//div[@class='w3-large']"));
			String s3=e3.getText();
			System.out.println("PYTHON RESULT");
			System.out.println(s3); 

			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[normalize-space()='Quiz Java']")).click();
			Thread.sleep(2000);
			for(int kk=1;kk<=25;kk++)
			{
				WebElement select = driver.findElement(By.xpath("//label[@id='label2']"));
				WebElement next = driver.findElement(By.xpath("//button[contains(text(),'Next ❯')]"));
				if(select.isDisplayed())
				{
					select.click();
					next.click();
					Thread.sleep(1000);
				}	
			}
			WebElement e4 =driver.findElement(By.xpath("//div[@class='w3-large']"));
			String s4=e4.getText();
			System.out.println("JAVA RESULT");
			System.out.println(s4); 
			count++;
			if(count==2)
				
			{
				break;
			}
		}
		}
	driver.quit();
}
}

