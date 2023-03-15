package vTiger_Practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridPractice {
	
	public static void main(String[] args) throws MalformedURLException {
		//load hub url - remote address URL 
		URL url = new URL("http://192.168.43.56:4444"); 
		//set capabilities for browser 
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("firefox"); cap.setPlatform(Platform.WINDOWS); 
		//launch browser using remote webdriver 
		 RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		//load gmail application 
		driver.get("https://gmail.com");
	}

}
