package vTiger_Products_TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vTiger.ObjectReposotary.CreateNewProductPage;
import vTiger.ObjectReposotary.HomePage;
import vTiger.ObjectReposotary.LoginPage;
import vTiger.ObjectReposotary.ProductsPage;
import vTiger_genericutility.ExcelFileUtility;
import vTiger_genericutility.JavaUtility;
import vTiger_genericutility.PropertiesFileUtility;
import vTiger_genericutility.WebDriverUtility;

public class CreateProductWithProductsCatgoryPOM {
	public static void main(String[] args) throws Exception {
		//create object for all required clasess
		PropertiesFileUtility pUtil=new PropertiesFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		String URL = pUtil.readDataFromPropertyFile("url");
		//step1:Launch the browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
			System.out.println("invalid browser found");
		wUtil.maximize(driver);
		wUtil.waitforloadPage(driver);
		driver.get(URL);
		//step2:login to application
		LoginPage lp=new LoginPage(driver);
		lp.loginapp(USERNAME, PASSWORD);
		//step3:Navigate to the products link
		HomePage hp=new HomePage(driver);
		hp.clickonProductsLink();
		//step4:click on Products lookup img
		ProductsPage pp=new ProductsPage(driver);
		pp.clickonProdctsImg();
		//step5:provide neccsary fields and save the data
		String PRODUCTCATGORYDROPDWN = eUtil.readDatafromExcel("products",4,3);
		String PRODUCTNAME = eUtil.readDatafromExcel("products", 4, 2);
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.createNewProduct(PRODUCTNAME, PRODUCTCATGORYDROPDWN);
		
		String productcatHeader = driver.findElement(By.id("dtlview_Product Category")).getText();
		if(PRODUCTCATGORYDROPDWN.equals(productcatHeader))
		{
			System.out.println(productcatHeader);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		
	}

}
