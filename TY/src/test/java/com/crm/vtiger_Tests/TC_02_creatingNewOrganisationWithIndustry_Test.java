package com.crm.vtiger_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.genericUtils.ExcelFileUtility;
import com.crm.genericUtils.JSONfileUtilities;
import com.crm.genericUtils.JavaUtility;
import com.crm.genericUtils.WebdriverUtility;

public class TC_02_creatingNewOrganisationWithIndustry_Test {
	
	WebDriver driver;
	@Test
	public void createOrgEduTest() throws Throwable {
	JSONfileUtilities jsLib=new JSONfileUtilities();
	JavaUtility jLib =new JavaUtility();
	WebdriverUtility wLib= new WebdriverUtility();
	ExcelFileUtility eLib = new ExcelFileUtility();
	
	String BROWSER = jsLib.readDataFromJSON("browser");
	String URL = jsLib.readDataFromJSON("url");
	String USERNAME = jsLib.readDataFromJSON("username");
	String PASSWORD = jsLib.readDataFromJSON("password");
	String orgName = eLib.getExcelData("Sheet1", 1, 3);
	String indusrtyName = eLib.getExcelData("Sheet1", 1, 4);
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
		
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("invalid browser");
	}
	
	
	wLib.waitForPageLoad(driver);
	wLib.maximizeWindow(driver);
	driver.get(URL);
	
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgName+jLib.getRandomNum());
	
	WebElement ele = driver.findElement(By.name("industry"));
	wLib.select(ele,indusrtyName);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(3000);
	WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wLib.mouseOver(driver, ele1);
	driver.findElement(By.linkText("Sign Out")).click();
	driver.close();
	}
}
