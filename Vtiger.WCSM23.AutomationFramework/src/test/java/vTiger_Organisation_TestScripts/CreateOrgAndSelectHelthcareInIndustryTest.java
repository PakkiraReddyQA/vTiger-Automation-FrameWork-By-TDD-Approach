package vTiger_Organisation_TestScripts;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;

import vTiger.ObjectReposotary.CreateNewOrganizationPage;
import vTiger.ObjectReposotary.HomePage;
import vTiger.ObjectReposotary.OrganizationInfoPage;
import vTiger.ObjectReposotary.OrganizationPage;
import vTiger_genericutility.BaseClass;

@Listeners(vTiger_genericutility.ListenersImplementaionClass.class)
public class CreateOrgAndSelectHelthcareInIndustryTest extends BaseClass {
	@Test
	public void craeteOrgWithIndustry() throws Exception {
		
		String ORGNAME = eUtil.readDatafromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDatafromExcel("Organization", 4, 3);
		
		
		//step1:click on organization
		HomePage hp=new HomePage(driver);
		hp.clickonOrganizationsLink();
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrganizationImg();
		//step2:create to new org with industry and save 
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.createNeworganization(ORGNAME, INDUSTRY);
		//Step3:Validation
		OrganizationInfoPage orgf=new OrganizationInfoPage(driver);
		String ORGHEADER = orgf.orgnizationHeaderText();
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		Reporter.log(ORGHEADER);
//		System.out.println(ORGHEADER);

	
	}

}
