package vTiger.ObjectReposotary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;

public class DropDowns {
	
	@FindBy(xpath = "//span[text()='Users']")
	private WebElement UserLnk;
	
	
	
	public DropDowns(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getUserLnk() {
		return UserLnk;
	}
	
	
	public void UsersDropDwnHandle(WebDriver driver,String Instituiton)
	{
		UserLnk.click();
		driver.findElement(By.xpath("//*[text()='"+Instituiton+"']")).click();
		driver.findElement(By.xpath("//*[text()='Demo sis school']")).click();
		
		
	
		
	}
	

}
