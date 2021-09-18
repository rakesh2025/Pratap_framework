package com.crm.genericUtils;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * this class contains all generic methods related to webdriver actions 
 * @author Bhanu
 *
 */
public class WebdriverUtility {
	/**
	 * this method will wait for the pageload for 15 seconds
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	/**
	 * this method will maximize the window
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();	
	}
	/**
	 * this method will select from the dropdown using visible text
	 */
	public void select(WebElement ele, String text)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	/**
	 * this method will select from the dropdown using index
	 */
	public void select(WebElement ele,int index)
	{
		Select s=new Select(ele);
		s.selectByIndex(index);
	}
	
	/**
	 * this method is used for mouse over action
	 */
	public void mouseOver(WebDriver driver, WebElement ele)
	{
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	/**
	 * this method is used to do right click
	 */
	public void rightClick(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.contextClick(ele).perform();
	}
	/**
	 * this method is used to do double click
	 */
	public void doubleClick(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
	/**
	 * this method accept the alert popup
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method dismiss the alert popup
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method will switch to frame wrt to index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method will switch to frame wrt to id
	 */
	public void switchToFrame(WebDriver driver,String frameId)
	{
		driver.switchTo().frame(frameId);
	}
	/**
	 * this method will switch to frame wrt to element
	 */
	public void switchToFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * this method will switch to window wrt partial windows text
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		Set<String> windowsH = driver.getWindowHandles();
		Iterator<String> it = windowsH.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			String actTitle=driver.switchTo().window(winId).getTitle();
			if(actTitle.contains(partialWinTitle))
			{
				driver.switchTo().window(actTitle);
				break;
			}
		}
		
	}
	

}
