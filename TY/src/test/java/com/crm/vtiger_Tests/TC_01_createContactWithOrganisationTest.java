package com.crm.vtiger_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.genericUtils.ExcelFileUtility;
import com.crm.genericUtils.JSONfileUtilities;
import com.crm.genericUtils.WebdriverUtility;


public class TC_01_createContactWithOrganisationTest {
	
	WebDriver driver;
	@Test
	public void createNewContactTest() throws Throwable {
		
		//read all the necessary data
		JSONfileUtilities jsonLib=new JSONfileUtilities();
		WebdriverUtility wdLib=new WebdriverUtility();
		ExcelFileUtility excelLib=new ExcelFileUtility();
		
		String URL = jsonLib.readDataFromJSON("url");
		String BROWSER = jsonLib.readDataFromJSON("browser");
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");
		
		String contactName=excelLib.getExcelData("sheet1", 1, 2);
		String orgName = excelLib.getExcelData("sheet1", 1, 3);
		
		//launch from browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver =new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		wdLib.waitForPageLoad(driver);
		wdLib.maximizeWindow(driver);
		driver.get(URL);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on create contact link
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//enter contacts details
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		wdLib.switchToWindow(driver, "Accounts");
		
		//search organisation and select
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("shriram transport")).click();
		
		wdLib.switchToWindow(driver, "Contacts&action");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wdLib.mouseOver(driver, ele);
		//signout 
		driver.findElement(By.linkText("Sign Out")).click();
		Assert.assertTrue(false);
		
		driver.close();
		

	}

}
