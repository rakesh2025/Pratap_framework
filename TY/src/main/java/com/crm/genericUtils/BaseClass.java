package com.crm.genericUtils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.Vtiger.pom_pages.Homepage;
import com.crm.Vtiger.pom_pages.Loginpage;

public class BaseClass {
	
	public JSONfileUtilities jsLib=new JSONfileUtilities();
	public JavaUtility jLib =new JavaUtility();
	public WebdriverUtility wLib= new WebdriverUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public WebDriver driver;
	public static WebDriver staticDriver;
	
	
@BeforeSuite (groups = {"SmokeSuite","RegressionSuite"})
public void connectDB()
{
	System.out.println("making Database Connection");
}
//@Parameters("browser")
@BeforeClass (groups = {"SmokeSuite","RegressionSuite"})
public void LaunchBrowser() throws Throwable
{
	System.out.println("---Launching the Browser---");
	String BROWSER = jsLib.readDataFromJSON("browser");
	String URL = jsLib.readDataFromJSON("url");
	
	
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
	staticDriver=driver;
}



@BeforeMethod (groups = {"SmokeSuite","RegressionSuite"})
public void Loginapp() throws Throwable
{
    String USERNAME=jsLib.readDataFromJSON("username");
    String PASSWORD=jsLib.readDataFromJSON("password");
	Loginpage lp=new Loginpage(driver);
	lp.LoginToHomepage(USERNAME, PASSWORD);
}

@AfterMethod (groups = {"SmokeSuite","RegressionSuite"})
public void LogoutApp()
{
	Homepage hp=new Homepage(driver);
	hp.signOut(driver);
}
@AfterClass (groups = {"SmokeSuite","RegressionSuite"})
public void closeBrowser()
{
	driver.close();
	System.out.println("browser closed");
}
@AfterSuite (groups = {"SmokeSuite","RegressionSuite"})
public void closeDatabase()
{
	System.out.println("database closed");
}
public String getScreenshot(String name) throws Throwable
{
	JavaUtility jva=new JavaUtility();
	String date = jva.getDateAndTime();
TakesScreenshot ts=(TakesScreenshot)staticDriver;
File src = ts.getScreenshotAs(OutputType.FILE);
String destFile = System.getProperty("user.dir")+"/Screenshot/"+name+date+".png";
File dest=new File(destFile);
FileUtils.copyFile(src, dest);
return destFile;

}
}
