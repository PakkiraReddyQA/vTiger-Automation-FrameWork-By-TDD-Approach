package vTiger_Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import vTiger.ObjectReposotary.CreateNewOrganizationPage;
import vTiger.ObjectReposotary.HomePage;
import vTiger.ObjectReposotary.OrganizationInfoPage;
import vTiger.ObjectReposotary.OrganizationPage;
import vTiger_genericutility.BaseClass;

public class CreateOrgWithIndustryPOMPractice extends BaseClass {
	@Test
	public void createOrgWithIndustryTest() throws EncryptedDocumentException, IOException
	{
		String INDUSTRY = eUtil.readDatafromExcel("Organization", 4, 3);
		String ORGNAME = eUtil.readDatafromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
		//Step1:clcik on orgnization name
		HomePage hp=new HomePage(driver);
		hp.clickonOrganizationsLink();
		//Step2:click on create org name img
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrganizationImg();
		//Step3:provide mantadatory fileds and save
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createNeworganization(ORGNAME, INDUSTRY);
		//Step4:validation
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader = oip.orgnizationHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		Assert.fail();
		
	}

}
