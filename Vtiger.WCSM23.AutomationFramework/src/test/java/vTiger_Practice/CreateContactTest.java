package vTiger_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContactTest {
	public static void main(String[] args) throws Exception {
		// Step1 launching Browser
//		System.setProperty("webdriver.chrome.driver", "D:\\kphb1\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		// Step2:Login to application
		Thread.sleep(3000);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		// Step3:Contact link
		driver.findElement(By.linkText("Contacts")).click();
		// Step4:Click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		// Step5:create Contact with mandatory fields
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("OMSaiRam");
		// Step6:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// Step7:validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (contactHeader.contains("OMSaiRam")) {
			System.out.println(contactHeader);
			System.out.println("Pass");
		} else
			System.out.println("Fail");
	}

}
