package vTiger_Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vTiger.ObjectReposotary.CreateNewOrganizationPage;
import vTiger.ObjectReposotary.HomePage;
import vTiger.ObjectReposotary.LoginPage;
import vTiger.ObjectReposotary.OrganizationPage;
import vTiger_genericutility.ExcelFileUtility;
import vTiger_genericutility.JavaUtility;
import vTiger_genericutility.PropertiesFileUtility;
import vTiger_genericutility.WebDriverUtility;


public class PomClassPractice {
	public static void main(String[] args) throws Exception, IOException {
		WebDriver driver=new ChromeDriver();
		PropertiesFileUtility pUtil=new PropertiesFileUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
//		String USERNAME = pUtil.readDataFromPropertyFile("username");
//		String PASSWORD = pUtil.readDataFromPropertyFile("password");
//		WebDriverUtility wUtil=new WebDriverUtility();
//		wUtil.maximize(driver);
//		wUtil.waitforloadPage(driver);
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.getUserNameEdt().sendKeys("admin");
		lp.getPasswordEdt().sendKeys("admin");
		lp.getLoginButton().click();
//		lp.loginapp("admin", "admin");
		//click on organization
		HomePage hp=new HomePage(driver);
		hp.getOrganizationLnk().click();
		//click on organization lookup icon
		OrganizationPage orgp=new OrganizationPage(driver);
		orgp.getOrgLookupBtn().click();
		
		//provide all neccesary data to the fields
		ExcelFileUtility eUtil=new ExcelFileUtility();
		JavaUtility jUtil=new JavaUtility();
		String ORGNAME= eUtil.readDatafromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.getOrgNameEdt().sendKeys(ORGNAME);
		//click on save button
		cno.getSaveBtn().click();
		
		
		
		
		
		
		
		
		
	}

}
