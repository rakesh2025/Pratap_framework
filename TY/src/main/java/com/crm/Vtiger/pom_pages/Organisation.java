package com.crm.Vtiger.pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtils.WebdriverUtility;

public class Organisation extends WebdriverUtility  {
	/**
	 * declaration
	 */
	public Organisation(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * initialization of elements
	 */
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewOrganistion;
	
	/**
	 * Utilization of elements and business methods
	 */
	public void createNewOrganisationBtn() 
	{
		//System.out.println(getCreateNewOrganistion().getAttribute("title"));
		createNewOrganistion.click();
	}

	public WebElement getCreateNewOrganistion() {
		return createNewOrganistion;
	}
	
}
