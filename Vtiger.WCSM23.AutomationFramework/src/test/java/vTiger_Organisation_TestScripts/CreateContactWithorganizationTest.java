package vTiger_Organisation_TestScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
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

@Listeners(vTiger_genericutility.ListnersImplentation.class)

public class CreateContactWithorganizationTest extends BaseClass {
	@Test(groups = "smokesuite")
	public void createContactWithOrg() throws Exception
	{
		
		/*read data from excel sheet*/
		String LASTNAME = eUtil.readDatafromExcel("contacts", 7, 2);
		String ORGNAME = eUtil.readDatafromExcel("contacts", 7, 3)+jUtil.getRandomNumber();
		
		
		//step1:navigate to organization link
		HomePage hp=new HomePage(driver);
		hp.clickonOrganizationsLink();
		//step2:lick on organization look up icon
		OrganizationPage org=new OrganizationPage(driver);
		org.clickOnOrganizationImg();
		//step3:fill all the mandtory fields
		CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		cnp.createNeworganization(ORGNAME);
		//step4:validate orgname
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgHeader = oip.orgnizationHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		//step5:navigate to contacts link
		hp.clickonContactsLink();
		//step6:click on contact look up icon
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactlookUPimg();
		//step7:create new contact with org name
		CreateNewContactsPage cp1=new CreateNewContactsPage(driver);
		cp1.createNewContact(driver, LASTNAME, ORGNAME);
	    //step8:validation for contact
		ContactstInfoPage cip=new ContactstInfoPage(driver);
		String contactHeader = cip.contactHeaderText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));	 
	}
	}


