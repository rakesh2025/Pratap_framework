package com.crm.Vtiger.pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this page contains elements and business methods of login page
 * @author Bhanu
 *
 */
public class Loginpage {

	/**
	 * declaration 
	 */
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * initialization of elements
	 */
	
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	public void LoginToHomepage(String username,String password)
	{
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}
	
	
}
