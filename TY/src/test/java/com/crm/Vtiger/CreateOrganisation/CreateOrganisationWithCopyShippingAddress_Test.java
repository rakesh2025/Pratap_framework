package com.crm.Vtiger.CreateOrganisation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Vtiger.pom_pages.Homepage;
import com.crm.Vtiger.pom_pages.Organisation;
import com.crm.Vtiger.pom_pages.CreateOrganisation;
import com.crm.genericUtils.BaseClass;

public class CreateOrganisationWithCopyShippingAddress_Test extends BaseClass {
	
	@Test(groups = "RegressionSuite",retryAnalyzer =com.crm.genericUtils.RetryAnalyzer.class)
	public void CreateOrganisationTC_01_Test() throws Throwable
	{
		String shippingAddr = eLib.getExcelData("sheet1", 1, 7);
		
		Homepage hp=new Homepage(driver);
		hp.OrganisationBtn();
		
		Organisation og = new Organisation(driver);
		og.createNewOrganisationBtn();
		
		CreateOrganisation co=new CreateOrganisation(driver);
		co.createOrganisationCopyShippingAddr(shippingAddr);
		
		Assert.assertTrue(co.getCopyShipAddrBtn().isEnabled());
		System.out.println("copy shipping address button is enabled");
	}

}
