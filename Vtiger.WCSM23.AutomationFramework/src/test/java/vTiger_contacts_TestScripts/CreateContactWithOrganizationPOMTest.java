package vTiger_contacts_TestScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.ObjectReposotary.ContactsPage;
import vTiger.ObjectReposotary.ContactstInfoPage;
import vTiger.ObjectReposotary.CreateNewContactsPage;
import vTiger.ObjectReposotary.CreateNewOrganizationPage;
import vTiger.ObjectReposotary.HomePage;
import vTiger.ObjectReposotary.OrganizationInfoPage;
import vTiger.ObjectReposotary.OrganizationPage;
import vTiger_genericutility.BaseClass;


@Listeners(vTiger_genericutility.ListenersImplementaionClass.class)

public class CreateContactWithOrganizationPOMTest extends BaseClass{
	@Test(groups = {"regressionSuite","smkesuite"})
	public void createContactWithOrgTest() throws Exception 
	{
	/*read the data from excel*/
	String LASTNAME = eUtil.readDatafromExcel("contacts", 4, 3);
	String INDUSTRY = eUtil.readDatafromExcel("Organization", 4, 3);
    String ORGNAME = eUtil.readDatafromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
	
	//Step3:Navigate to the organization
	HomePage hp=new HomePage(driver);
	hp.clickonOrganizationsLink();
	Reporter.log("--clicked on Organization link--",true);
	//step4:click on create new org img
	OrganizationPage op=new OrganizationPage(driver);
	op.clickOnOrganizationImg();
	Reporter.log("--clicked on Organization look Image--",true);
	//step4:provide all mandtory fileds and save
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.createNeworganization(ORGNAME, INDUSTRY);
	Reporter.log("--Organization created with Industry and saved succefully --",true);
	//validation
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String OrgHeader = oip.orgnizationHeaderText();
	Assert.assertTrue(OrgHeader.contains(ORGNAME));
	//step5:Navigate The Contacts
	hp.clickonContactsLink();
	Reporter.log("--clicked on Contacts link--",true);
	//step6:click on the create new contact Img
	ContactsPage cp=new ContactsPage(driver);
	cp.clickOnCreateContactlookUPimg();
	Reporter.log("--clicked on Contact lookUp Image link--",true);
	//step7:provide mandatory fileds for creating new contact and save
	CreateNewContactsPage cnp=new CreateNewContactsPage(driver);
	cnp.createNewContact(driver, LASTNAME, ORGNAME);
	Reporter.log("--Organization created  with contact and saved succefully --",true);
	//validation
	ContactstInfoPage cip=new ContactstInfoPage(driver);
	String contactHeader = cip.contactHeaderText();
	Assert.assertTrue(contactHeader.contains(LASTNAME));
	}
	@Test
	public void test()
	{
		System.out.println("test1");
	}
	@Test
	public void test2()
	{
		System.out.println("test2");
	}
	@Test
	public void test3()
	{
		System.out.println("test3");
	}
	@Test
	public void test4()
	{
		System.out.println("test4");
	
	}
	
}
