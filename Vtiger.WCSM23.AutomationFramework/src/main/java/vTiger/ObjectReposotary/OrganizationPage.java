package vTiger.ObjectReposotary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement OrgLookupBtn;
   @FindBy(xpath = "//img[@title='Search in Organizations...']")
   private WebElement searchIconBtn;
   @FindBy(name = "search_text")
   private WebElement searchBarEdt;
   @FindBy(name="submit")
   private WebElement searchBtn;
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrgLookupBtn() {
		return OrgLookupBtn;
	}
	public WebElement getSearchIconBtn() {
		return searchIconBtn;
	}
	public WebElement getSearchBarEdt() {
		return searchBarEdt;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public void clickOnOrganizationImg()
	{
		OrgLookupBtn.click();
	}
	
	

}
