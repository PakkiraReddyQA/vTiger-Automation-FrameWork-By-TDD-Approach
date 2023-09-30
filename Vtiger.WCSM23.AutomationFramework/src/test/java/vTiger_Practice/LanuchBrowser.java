package vTiger_Practice;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;0000000000
import org.openqa.selenium.firefox.FirefoxDriver;

public class LanuchBrowser {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		Thread.sleep(3000);
		driver.get("http://localhost:8888/");
	}

}
