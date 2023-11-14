package dthmlGoodies;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import vTiger_genericutility.WebDriverUtility;

public class DragAndDrop {
	public static void main(String[] args) throws InterruptedException {
		
		
		
		WebDriverUtility wUtil=new WebDriverUtility();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
      WebDriver driver=new ChromeDriver(options);
      wUtil.waitforloadPage(driver);
      
      driver.get("http://www.dhtmlgoodies.com/");
     
      driver.findElement(By.xpath("//a[text()='Drag and drop']")).click();
      Thread.sleep(2000);
      
      JavascriptExecutor js=(JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,3000);");
      
       WebElement e = driver.findElement(By.xpath("(//a[text()='Demo'])[9]"));
      wUtil.waitElementToBeClickable(driver,e);
      e.click();
      Thread.sleep(1000);
      wUtil.switchTowindow(driver, "Drag and Drop to the columns");
      
 WebElement ele = driver.findElement(By.id("//*[@id='node1']"));
      WebElement ele1 = driver.findElement(By.xpath("(//div[@id='dhtmlgoodies_mainContainer']//div//ul)[1]"));
      Actions act=new Actions(driver);
  	act.dragAndDrop(ele, ele1).perform();
      
//      for(WebElement k:ele)
//      {
//    	Actions act=new Actions(driver);
//    	act.dragAndDrop(k, ele1).perform();
//      }
	}

}
