package webTablesHandling;


import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.ObjectReposotary.HomePage;
import vTiger.ObjectReposotary.OrganizationPage;
import vTiger_genericutility.BaseClass;
import vTiger_genericutility.ListenersImplementaionClass;
@Listeners(ListenersImplementaionClass.class)

public class ClickOnAllcheckBoxesTest extends BaseClass {
	@Test
	public void checkBoxesTest()
	{
		Reporter.log("******* Test check all check Boxes ******");
		//Navigate to Organization Link
		HomePage hp=new HomePage(driver);
		hp.clickonOrganizationsLink();
		OrganizationPage op=new OrganizationPage(driver);
		//Click on All check Box
		op.checkBoxClickAllIndividually(driver);
	}
	@Test
	public void clickonSelectAll()
	{
		//Navigate to Organization 
		HomePage hp=new HomePage(driver);
		hp.clickonOrganizationsLink();
		//Click on Select All CheckBox
		OrganizationPage op=new OrganizationPage(driver);
		op.selectAllcheckBoxClick();
	}
	@Test
	public void printOrgs()
	{
		//Navigate to Organization Link
		HomePage hp=new HomePage(driver);
		hp.clickonOrganizationsLink();
		//Print all Organizations presnets in the page
		OrganizationPage op=new OrganizationPage(driver);
		op.printOrganizations();
	}
	@Test
	public void checkFifthBox()
	{
		//Navigate to Organization Link
		HomePage hp=new HomePage(driver);
		hp.clickonOrganizationsLink();
		Reporter.log("****** Select Check Box Based On Index*******");
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCheckBoxBasedOnIndex(driver, 9);
	}
	@Test
	public void checkEightBoxThenDelete()
	{
		//Navigate to Organization Link
				HomePage hp=new HomePage(driver);
				hp.clickonOrganizationsLink();
				Reporter.log("****** Select Check Box Based On Index*******");
				OrganizationPage op=new OrganizationPage(driver);
				op.clickOnCheckBoxBasedOnIndex(driver, 12);	
				
	}
}
