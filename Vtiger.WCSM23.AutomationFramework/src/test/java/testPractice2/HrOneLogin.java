package testPractice2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HrOneLogin {
	@Test
	void hrone()
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://app.hrone.cloud/login");
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("9618456544");
//		driver.findElement(B)
	}

}
