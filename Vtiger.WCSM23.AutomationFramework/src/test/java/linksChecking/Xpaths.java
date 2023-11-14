package linksChecking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpaths {


	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://192.168.0.40:7443/tims/login");
		Thread.sleep(1500);

		driver.manage().window().maximize();

		handleAdvancedOptions(driver);

		login(driver, "twcadm", "zxcv1234");

		navigateToNetworkSettings(driver);

		addNewIP(driver, "5.0.0.0", "Check");

		// Additional actions can be added here

		driver.quit();
	}

	private static void handleAdvancedOptions(WebDriver driver) throws InterruptedException {
		String[] xPaths = {
				"//button[@id='details-button']",
				"//a[@class='small-link']"
		};

		performActions(driver, xPaths);
	}

	private static void login(WebDriver driver, String username, String password) throws InterruptedException {
		String[] xPaths = {
				"//input[@id='userid']",
				"//input[@id='password']",
				"//button[@id='commit']"
		};

		performActions(driver, xPaths, username, password);
		Thread.sleep(1500);
	}

	private static void navigateToNetworkSettings(WebDriver driver) throws InterruptedException {
		String[] xPaths = {
				"//*[@id=\"twc_dm_network_management_parent\"]",
				"//*[@id=\"twc_dm_network\"]",
				"//*[@id=\"buttons\"]/div/a[1]"
		};

		performActions(driver, xPaths);
	}

	private static void addNewIP(WebDriver driver, String ipAddress, String name) throws InterruptedException {
		String[] xPaths = {
				"//*[@id=\"address\"]",
				"//*[@id=\"tw_ntr_name\"]",
				"//*[@id=\"submitButton\"]",
				"/html/body/div[16]/div[7]/div/button",
				"//*[@id=\"networkGrid\"]/tbody/tr[4]/td[4]",
				"//*[@id=\"buttons\"]/div/a[1]",
				"//*[@id=\"single_multi_check\"]/label[1]/span"
		};

		performActions(driver, xPaths, ipAddress, name);
	}

	private static void performActions(WebDriver driver, String[] xPaths, String...values) throws InterruptedException {
		for (int i = 0; i < xPaths.length; i++) {
			WebElement element = driver.findElement(By.xpath(xPaths[i]));
			if (values.length > i && values[i] != null) {
				element.sendKeys(values[i]);
			} else {
				element.click();
			}
			Thread.sleep(1500);
		}
	}

}

