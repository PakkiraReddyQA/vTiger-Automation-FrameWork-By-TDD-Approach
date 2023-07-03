package linksChecking;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import vTiger_genericutility.BaseClass;

public class LinksCheckingwithVtiger  {
	@Test
	void linksVerification() throws IOException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://amazon.com/");
		List<WebElement> element = driver.findElements(By.tagName("a"));
		System.out.println(element.size());
		for(WebElement webel:element)
		{
			String links = webel.getDomAttribute("href");
			try
			{
			URL url=new URL(links);
			HttpURLConnection httpconn=(HttpURLConnection) url.openConnection();
			httpconn.connect();
			
			int respcode = httpconn.getResponseCode();
			SoftAssert ass=new SoftAssert();
			
			if(respcode>=400)
			{
				System.out.println(links+"its broken link");
			}
			
			else
			{
				System.out.println(links+"its valid link");
			}
			}
			catch(Exception e)
			{
				System.out.println(links+"its broken link");
			}
		}
	}
}
