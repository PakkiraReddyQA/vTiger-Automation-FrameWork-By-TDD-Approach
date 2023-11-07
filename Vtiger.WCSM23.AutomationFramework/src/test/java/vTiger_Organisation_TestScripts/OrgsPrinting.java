package vTiger_Organisation_TestScripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import vTiger.ObjectReposotary.HomePage;
import vTiger.ObjectReposotary.LoginPage;
import vTiger.ObjectReposotary.OrganizationPage;
import vTiger_genericutility.BaseClass;

public class OrgsPrinting extends BaseClass{
	@Test
	public void OrgTolist()
	{

		HomePage hp1=new HomePage(driver);
		hp1.clickonOrganizationsLink();

		Map<String, List> Entities=new HashMap<String,List>();

		List<WebElement> headers=driver.findElements(By.xpath("//table/tbody/tr/td[@class='lvtCol']"));

		for(int i=0;i<headers.size();i++)
		{
			String Headrstext = headers.get(2).getText();

						System.out.println(Headrstext);
			//		@SuppressWarnings("unchecked")

			List<WebElement>headervalues =  driver.findElements(By.xpath("//a[@title='Organizations']"));

			List lt=new ArrayList();

			for(int j=0;j<headervalues.size();j++)
			{
				String values1 =headervalues.get(j).getText();

                System.out.println(values1);
                
//				lt.add(values1);
//				System.out.println(lt);

				//			System.out.println(Headrstext+"--->"+values);
				//			Entities.put(Headrstext, values);
			}

//			for( List value:lt)
//			{
//				Entities.put(Headrstext, value);
//			}
//			System.out.println(Entities);
		}
		//		

	}

	@Test
	void PrintRowsColumns()
	{
		HomePage hp1=new HomePage(driver);
		hp1.clickonOrganizationsLink();

		List<WebElement> headers=driver.findElements(By.xpath("//table/tbody/tr/td[@class='lvtCol']"));


		for(int i=0;i<=headers.size();i++)
		{

			String heders = headers.get(i).getText();
			System.out.println(heders); 

		}
		
		List<WebElement> headervalues =  driver.findElements(By.xpath("//a[@title='Organizations']"));

		for(int j=0;j<headervalues.size()-1;j++)
		{
			String value = headervalues.get(j).getText();
			System.out.println(value);
		}

	}
}







