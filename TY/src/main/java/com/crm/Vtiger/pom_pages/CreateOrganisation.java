package com.crm.Vtiger.pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtils.WebdriverUtility;

public class CreateOrganisation extends WebdriverUtility{
	/**
	 * declaration
	 * @param driver
	 */
	public CreateOrganisation(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * initialization 
	 */
	@FindBy(name="accountname")
	private WebElement orgNameEdit;
	
	@FindBy(name="ship_street")
	private WebElement shippingAddrEdit;
	
	@FindBy(xpath="//input[@name='cpy']")
	private WebElement copyShipAddrBtn;
	
	public WebElement getCopyShipAddrBtn() {
		return copyShipAddrBtn;
	}
	
	@FindBy(name="bill_street")
	private WebElement billingAddrEdit;
	
	@FindBy(xpath="(//input[@name='cpy'])[2]")
	private WebElement copyBillAddrBtn;
	
	public WebElement getCopyBillAddrBtn() {
		return copyBillAddrBtn;
	}

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutBtn;
	
	public WebElement getAdministratorBtn() {
		return AdministratorBtn;
	}

	

	/**
	 * utilization
	 */
	public void createOrganisationCopyShippingAddr(String address)
	{
		shippingAddrEdit.sendKeys(address);
		copyShipAddrBtn.click();
	}
	
	public void createOrganisationCopyBillingAddr(String address)
	{
		billingAddrEdit.sendKeys(address);
		copyBillAddrBtn.click();
	}
	
	public void createOrganisationShippingAddr(String orgName,String address)
	{
		orgNameEdit.sendKeys(orgName);
		shippingAddrEdit.sendKeys(address);
		saveBtn.click();
	}
	
	public void createOrganisationWithoutShippingAddr(String orgName)
	{
		orgNameEdit.sendKeys(orgName);
		saveBtn.click();
	}
	public void createOrganisationWithBillingAddr(String orgName,String address)
	{
		orgNameEdit.sendKeys(orgName);
		billingAddrEdit.sendKeys(address);
		saveBtn.click();
	}
	
	public void signOut(WebDriver driver)
	{
		mouseOver(driver, getAdministratorBtn());
		signOutBtn.click();
	}

}
