package vTiger_Organisation_TestScripts;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.ObjectReposotary.CreateNewOrganizationPage;
import vTiger.ObjectReposotary.HomePage;
import vTiger.ObjectReposotary.OrganizationInfoPage;
import vTiger.ObjectReposotary.OrganizationPage;
import vTiger_genericutility.BaseClass;

@Listeners(vTiger_genericutility.ListenersImplementaionClass.class)
public class CreateNewOrganizationWithIndustryPOMTest extends BaseClass {
	
	@Test
	public void createNewOrgWithIndustry() throws Exception
	 {
		
		//need to compoulsory this data for testing 
		/*Step1:read data from the excel file*/
		String ORGNAME = eUtil.readDatafromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDatafromExcel("Organization", 4, 3);
	
		//step2:navigate organization link
		HomePage hp=new HomePage(driver);
		hp.clickonOrganizationsLink();
		//step3:click on orgnization lookup img
		OrganizationPage orgp=new OrganizationPage(driver);
		orgp.clickOnOrganizationImg();
		//step4:proivde madatory fields and save
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.createNeworganization(ORGNAME, INDUSTRY);
		//Step5:validate for organization
		OrganizationInfoPage orgf=new OrganizationInfoPage(driver);
		String ORGHEADER = orgf.orgnizationHeaderText();
		//step6:Validation
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		
	}

}
