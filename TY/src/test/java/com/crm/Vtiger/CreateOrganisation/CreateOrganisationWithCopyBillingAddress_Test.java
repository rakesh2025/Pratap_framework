package com.crm.Vtiger.CreateOrganisation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Vtiger.pom_pages.CreateOrganisation;
import com.crm.Vtiger.pom_pages.Homepage;
import com.crm.Vtiger.pom_pages.Organisation;
import com.crm.genericUtils.BaseClass;

public class CreateOrganisationWithCopyBillingAddress_Test extends BaseClass {
	
	
	@Test(groups = "RegressionSuite",retryAnalyzer =com.crm.genericUtils.RetryAnalyzer.class)
	public void createOrganisation_TC_02_Test() throws Throwable
	{
		String billingAddr = eLib.getExcelData("sheet1", 1, 8);
		
		Homepage hp=new Homepage(driver);
		hp.OrganisationBtn();
		
		Organisation og = new Organisation(driver);
		og.createNewOrganisationBtn();
		
		CreateOrganisation co=new CreateOrganisation(driver);
		co.createOrganisationCopyBillingAddr(billingAddr);
		
		Assert.assertTrue(co.getCopyBillAddrBtn().isEnabled());
		System.out.println("copy billing address button is enabled");
	}

}
