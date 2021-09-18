package com.crm.Vtiger.CreateOrganisation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Vtiger.pom_pages.CreateOrganisation;
import com.crm.Vtiger.pom_pages.Homepage;
import com.crm.Vtiger.pom_pages.Organisation;
import com.crm.Vtiger.pom_pages.OrganisationInformation;
import com.crm.genericUtils.BaseClass;

public class CreateOrganisationWithoutShippingAddress_Test extends BaseClass {
	
	@Test(groups = "RegressionSuite",retryAnalyzer =com.crm.genericUtils.RetryAnalyzer.class)
	public void CreateOrganisationTC_04_Test() throws Throwable
	{
		String orgName = eLib.getExcelData("Sheet1", 1, 3)+jLib.getRandomNum();
		
		Homepage hp=new Homepage(driver);
		hp.OrganisationBtn();
		
		Organisation og = new Organisation(driver);
		og.createNewOrganisationBtn();
		
		CreateOrganisation co=new CreateOrganisation(driver);
		co.createOrganisationWithoutShippingAddr(orgName);
		
		OrganisationInformation oi = new OrganisationInformation(driver);
		String actualText = oi.getOrgInfoTitle().getText();
		String expectedText="Organization Information";
	
		Assert.assertTrue(actualText.contains(expectedText));
		System.out.println("organisation created successfully without shipping address");
	}
}
