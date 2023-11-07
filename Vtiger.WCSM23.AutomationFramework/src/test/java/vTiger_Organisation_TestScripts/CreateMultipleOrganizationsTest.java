package vTiger_Organisation_TestScripts;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.ObjectReposotary.CreateNewOrganizationPage;
import vTiger.ObjectReposotary.HomePage;
import vTiger.ObjectReposotary.OrganizationInfoPage;
import vTiger.ObjectReposotary.OrganizationPage;
import vTiger_genericutility.BaseClass;
//@Listeners(vTiger_genericutility.ListenersImplementaionClass.class)
public class CreateMultipleOrganizationsTest extends BaseClass {
	
	@Test(dataProvider = "orgNames")
	public void createMultipleorgTest(String ORG,String INDUSTRY) throws Exception
	{
		
		String ORGNAME = ORG+jUtil.getRandomNumber();
		
	
	 
		//step3:navigate to the organization link
		HomePage hp=new HomePage(driver);
		hp.clickonOrganizationsLink();
		System.out.println("Clicked on org link");
		//step4:click on create new orgnization img
		OrganizationPage orgp=new OrganizationPage(driver);
		orgp.clickOnOrganizationImg();
		//step5:provide mandtory orgname with industry
		CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		cnp.createNeworganization(ORGNAME, INDUSTRY);
		//STEP6:validation for org
		OrganizationInfoPage orgf=new OrganizationInfoPage(driver);
		 String ORGHEADER = orgf.orgnizationHeaderText();
		 
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		
		 /*if(ORGHEADER.contains(ORGNAME))
		 {
			 System.out.println(ORGHEADER+"--->PASS");
		 }
		 else
		 {
			 System.out.println("FAIL");
		 }*/
	}
	@DataProvider(name="orgNames")
	public  Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eUtil.readmultipleDatafromExcel("multipleOrgs");
		return data;
	}
}
