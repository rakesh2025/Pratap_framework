package com.crm.Vtiger.pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtils.WebdriverUtility;

public class Homepage extends WebdriverUtility{
	
	/**
	 * declaration
	 */
	public Homepage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * initialization of elements
	 */
	@FindBy(linkText="Organizations")
	private WebElement organisationBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorBtn;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutBtn;
	/**
	 * Utilization of elements and business methods
	 */
	public void OrganisationBtn()
	{
		organisationBtn.click();
	}
	
	public void signOut(WebDriver driver)
	{
		mouseOver(driver, getAdministratorBtn());
		signOutBtn.click();
	}

	public WebElement getAdministratorBtn() {
		return AdministratorBtn;
	}
	
	

}
