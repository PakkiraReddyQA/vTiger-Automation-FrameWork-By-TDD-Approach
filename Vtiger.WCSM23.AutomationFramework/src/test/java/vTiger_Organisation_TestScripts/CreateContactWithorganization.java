package vTiger_Organisation_TestScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger_genericutility.BaseClass;
@Listeners(vTiger_genericutility.ListenersImplementaionClass.class)

public class CreateContactWithorganization extends BaseClass{
	@Test(groups = "smokesuite")
	public void createContactWithOrg() throws Exception
	{
		
		/*read data from excel sheet*/
		String LASTNAME = eUtil.readDatafromExcel("contacts", 7, 2);
		String ORGNAME = eUtil.readDatafromExcel("contacts", 7, 3)+jUtil.getRandomNumber();
		
		
		//step1:navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		//step2:lick on organization look up icon
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//step3:fill all the mandtory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//step4:validate orgname
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		//step5:navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		//step6:click on contact look up icon
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//step7:create new contact 
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		//Step8:Choose organization name
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		wUtil.switchTowindow(driver, "Accounts");
		
		                                                   //wipro
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		                                 //dynamic path //a[text()='wipro']
		
	wUtil.switchTowindow(driver, "Contacts");
	//Step10:save
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 //step11:validation for contact
	 String contactHeader = driver.findElement(By.className("dvHeaderText")).getText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));

	 
	}
	}


