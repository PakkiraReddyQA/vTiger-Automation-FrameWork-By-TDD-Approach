package vTiger_Practice;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;0000000000
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import vTiger.ObjectReposotary.LoginPage;

public class LanuchBrowser {
	@Test
	void login() throws InterruptedException
	{
		WebDriver driver=new FirefoxDriver();
		Thread.sleep(3000);
		driver.get("http://localhost:8888/");
		LoginPage lp=new LoginPage(driver);
		lp.loginapp("admin","admin");
		String expected = "Administratoryt - Home - vtiger CRM 5 - Commercial Open Source CRM";
		String actual = driver.getTitle();
		Assert.assertEquals(actual,expected,"Title Mismathed");
	}

}
