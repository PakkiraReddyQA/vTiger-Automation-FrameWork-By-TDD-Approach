package vTiger_genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectReposotary.HomePage;
import vTiger.ObjectReposotary.LoginPage;
/**
 * this class contains all basic configuration Annataions 
 * @author pakkira Reddy
 *
 */
public class BaseClass {
	public PropertiesFileUtility pUtil=new PropertiesFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public JavaUtility jUtil=new JavaUtility();
    public 	WebDriverUtility wUtil=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver;//this is used for  take screen shot 
	
	@BeforeSuite(groups = {"smokesuite","regressionSuite"})
	public void bsConfiguration()
	{
		System.out.println("====Data Base connected successfully======");
	}
     //	@Parameters("browser")
	  @BeforeClass(groups = {"smokesuite","regressionSuite"})
	public void bcConfiguration(/*String BROWSER*/) throws Exception
	{
		//Launch the browser
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("===="+BROWSER+"====Launched succefully===");
			sdriver=driver;//this is used for  take screen shot in listeners
		}
		else if(BROWSER.equalsIgnoreCase("Firfox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("===="+BROWSER+"====Launched succefully===");
			sdriver=driver;//this is used for  take screen shot in listeners
		}
		else
		{
			System.out.println("inavlid browser found");
		}
		wUtil.maximize(driver);
		wUtil.waitforloadPage(driver);
		driver.get(URL);
		System.out.println("browser launched succefully");
	}
	@BeforeMethod(groups = {"smokesuite","regressionSuite"})
	public void bmConfiguration() throws Exception
	{
		//login to appliction
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginapp(USERNAME, PASSWORD);
		System.out.println("application loggedin successfully");
	}
	@AfterMethod(groups = {"smokesuite","regressionSuite"})
	public void amConfiguration()
	{
		HomePage hp=new HomePage(driver);
		hp.logoutofApp(driver);
		System.out.println("application loggedOut successfully");
	}
	@AfterClass(groups = {"smokesuite","regressionSuite"})
	public void acConfiguration()
	{
		driver.quit();
		System.out.println("Browser closed successfully");
	}
	
	@AfterSuite(groups = {"smokesuite","regressionSuite"})
	public void asConfiguration()
	{
		System.out.println("======Data Base connection closed=====");
	}
}
