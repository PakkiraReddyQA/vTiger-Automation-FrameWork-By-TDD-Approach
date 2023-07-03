package vTiger_Organisation_TestScripts;

import org.testng.annotations.Test;

import vTiger.ObjectReposotary.CreateNewOrganizationPage;
import vTiger.ObjectReposotary.HomePage;
import vTiger.ObjectReposotary.OrganizationPage;
import vTiger_genericutility.BaseClass;

public class createnewORG extends BaseClass {
	@Test
	public void createorg()
	{
		//click on organization link
		HomePage hp=new HomePage(driver);
		hp.clickonOrganizationsLink();
		
		//click on create new org button
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrganizationImg();
		
		//click on new org link
		
		CreateNewOrganizationPage cp=new CreateNewOrganizationPage(driver);
		cp.createNeworganization("sri sai", "Banking");
		
		
		
	}

}
