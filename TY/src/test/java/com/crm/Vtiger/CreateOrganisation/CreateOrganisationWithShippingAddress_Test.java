package com.crm.Vtiger.CreateOrganisation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Vtiger.pom_pages.CreateOrganisation;
import com.crm.Vtiger.pom_pages.Homepage;
import com.crm.Vtiger.pom_pages.Organisation;
import com.crm.Vtiger.pom_pages.OrganisationInformation;
import com.crm.genericUtils.BaseClass;

public class CreateOrganisationWithShippingAddress_Test extends BaseClass {
	
	@Test(groups = "SmokeSuite",retryAnalyzer =com.crm.genericUtils.RetryAnalyzer.class)
	public void CreateOrganisationTC_03_Test() throws Throwable
	{
		String orgName = eLib.getExcelData("Sheet1", 1, 3)+jLib.getRandomNum();
		String shippingAddr = eLib.getExcelData("sheet1", 1, 7);
		
		Homepage hp=new Homepage(driver);
		hp.OrganisationBtn();
		
		Organisation og = new Organisation(driver);
		og.createNewOrganisationBtn();
		
		CreateOrganisation co=new CreateOrganisation(driver);
		co.createOrganisationShippingAddr(orgName, shippingAddr);
		
		OrganisationInformation oi = new OrganisationInformation(driver);
		String actualText = oi.getOrgInfoTitle().getText();
		String expectedText="Organization Information";
	
		Assert.assertTrue(actualText.contains(expectedText));
		System.out.println("organisation created successfully with shipping address");
	}
}
