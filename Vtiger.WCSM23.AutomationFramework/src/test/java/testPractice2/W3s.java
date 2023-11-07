package testPractice2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class W3s {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://www.w3schools.com/");

		List<WebElement> ele = driver.findElements(By.xpath("//a[@class='ga-nav']"));
		for(int k=0;k<ele.size();k++)
		{
			String course = ele.get(k).getText();
			System.out.println(course);

		}
		for(int i=0;i<ele.size();i++)
		{
			String course = ele.get(i).getText();


			while(course.equals("SQL"))
			{
				Thread.sleep(1000);
				ele.get(i).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[normalize-space()='Start SQL Quiz!']")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Start the SQL Quiz ❯')]")).click();



				for(int j=0;j<=25;j++)
				{
					WebElement radiobutton = driver.findElement(By.className("radiocontainer"));
					if(radiobutton.isDisplayed())
					{
						Thread.sleep(1000);
						driver.findElement(By.id("label2")).click();

					}


					driver.findElement(By.xpath("//button[text()='Next ❯']")).click();
				}

			}

		}
	}
}


