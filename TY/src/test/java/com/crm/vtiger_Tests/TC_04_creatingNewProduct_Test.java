package com.crm.vtiger_Tests;

import java.util.List;

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

public class TC_04_creatingNewProduct_Test {

	 WebDriver driver;
	    @Test
		public void createProduct() throws Throwable {
	    	JSONfileUtilities jsLib=new JSONfileUtilities();
	    	//JavaUtility jLib =new JavaUtility();
	    	WebdriverUtility wLib= new WebdriverUtility();
	    	ExcelFileUtility eLib = new ExcelFileUtility();
	    	
	    	String BROWSER = jsLib.readDataFromJSON("browser");
	    	String URL = jsLib.readDataFromJSON("url");
	    	String USERNAME = jsLib.readDataFromJSON("username");
	    	String PASSWORD = jsLib.readDataFromJSON("password");
	    	String productName = eLib.getExcelData("Sheet1", 1, 5);
	    	String partNumber = eLib.getExcelData("Sheet1", 1, 6);
	    	
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
	    	driver.findElement(By.linkText("Products")).click();
	    	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	    	driver.findElement(By.name("productname")).sendKeys(productName);
	    	driver.findElement(By.id("productcode")).sendKeys(partNumber);
	    	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    	
	    	WebElement ele = driver.findElement(By.xpath("//td[contains(text(),'PR')]"));
			String expectedProduct = ele.getText();
			
			driver.findElement(By.linkText("Products")).click();
			
			WebElement ele1 = driver.findElement(By.id("bas_searchfield"));
			wLib.select(ele1,"Part Number");
			driver.findElement(By.name("search_text")).sendKeys(partNumber);
			
			
			
			
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			
			List<WebElement> map = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]"));
			for(WebElement wb:map) {
				
				String actualProduct = wb.getText();
				if(expectedProduct.contains(actualProduct))
				{
					System.out.println("product created and displayed in product list successfully");
				break;
				}
				
			}
			Thread.sleep(3000);
			WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wLib.mouseOver(driver, ele2);
			
			driver.findElement(By.linkText("Sign Out")).click();
	    	
	    	Thread.sleep(3000);
	    	driver.close();
	    	
	    	
}
}