package testPractice2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import vTiger.ObjectReposotary.HomePage;
import vTiger.ObjectReposotary.LoginPage;

public class LoginToapplication  {
	WebDriver driver;
	@Test
	void loginTOApp()
	{
		LoginPage lp=new LoginPage(driver);
		lp.loginapp("admin","admin");
	}
	@Parameters("browser")
	@Test
	void launchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("FireFox"))
		{
			driver=new FirefoxDriver();	
		}
		else
		{
			System.out.println("Invalid Browser Found");
		}
		driver.get("http://localhost:8888/");
	}
	@Test
	void clickOrg()
	{
		HomePage hpe=new HomePage(driver);
		boolean status = hpe.getOpportunitiesLnk().isDisplayed();
//		System.out.println(status);
	}
	@Test
	void verifyLogin()
	{
		 
		String expected="Administkkrator - Home - vtiger CRM 5 - Commercial Open Source CRMmmm";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expected,"Title Mismatched");
	}
	
	}


