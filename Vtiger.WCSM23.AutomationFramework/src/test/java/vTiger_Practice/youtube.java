package vTiger_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class youtube {
	@Test
	public void yt()
	{
		
		WebDriverManager.chromedriver().setup();
	    ChromeOptions options=new ChromeOptions();
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.youtube.com/"); 
		driver.manage().window().maximize();
		
	}

}
