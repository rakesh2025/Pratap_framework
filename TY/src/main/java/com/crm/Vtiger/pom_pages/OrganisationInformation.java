package com.crm.Vtiger.pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtils.WebdriverUtility;

public class OrganisationInformation extends WebdriverUtility{
	
	public OrganisationInformation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgInfoTitle;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorBtn;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutBtn;

	public WebElement getOrgInfoTitle() {
		return orgInfoTitle;
	}

	public WebElement getAdministratorBtn() {
		return AdministratorBtn;
	}

	public void signOut(WebDriver driver)
	{
		mouseOver(driver, getAdministratorBtn());
		signOutBtn.click();
	}
}
