package vTiger_contacts_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import vTiger.ObjectReposotary.ContactsPage;
import vTiger.ObjectReposotary.HomePage;
import vTiger_genericutility.BaseClass;

public class CreatecontactWithOrg extends BaseClass{
	@Test
	public void createContactWithOrgTest() throws Exception, IOException
	{
		String LASTNAME = eUtil.readDatafromExcel("contacts", 7, 3);
		String ORGNAME = eUtil.readDatafromExcel("contacts", 7, 4);
		
		//Navigate to the contacts link
		HomePage hp=new HomePage(driver);
		hp.clickonContactsLink();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactlookUPimg();
		
		
	}
}
