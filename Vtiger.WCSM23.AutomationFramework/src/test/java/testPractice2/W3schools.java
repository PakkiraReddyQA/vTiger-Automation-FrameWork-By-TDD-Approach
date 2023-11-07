package testPractice2;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class W3schools {

     public static void main(String[] args) throws Exception 
     {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> e = driver.findElements(By.xpath("//a[@class='ga-nav']"));
		
		for(int i=0;i<e.size();i++)
		{
		 String d = e.get(i).getText();
		 System.out.println(d);
		while(d.contains("SQL"))
		 {
			
			Thread.sleep(1000);
			e.get(i).click();  
		driver.findElement(By.xpath("//a[normalize-space()='Start SQL Quiz!']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Start the SQL Quiz ❯')]")).click();
		Thread.sleep(1000);
		for(int k=1;k<=25;k++)
		{
			WebElement select = driver.findElement(By.xpath("//label[@id='label2']"));
			WebElement next =driver.findElement(By.xpath("//button[contains(text(),'Next ❯')]"));
			if(select.isDisplayed())
			{
			select.click();
			Thread.sleep(1000);
			next.click();
			Thread.sleep(1000);
			}
			}
		driver.close();
//		break;
		}
		
		}
     }
}
