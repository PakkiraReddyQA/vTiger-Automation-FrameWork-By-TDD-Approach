package vTiger_Practice;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;0000000000
import org.openqa.selenium.firefox.FirefoxDriver;

public class LanuchBrowser {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888/");
	}

}
