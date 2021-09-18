package com.crm.genericUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
/**
 * this class contains generic methods pertaining to java
 * @author Bhanu
 *
 */
public class JavaUtility {
	
	/**
	 * this method generates and return random number 
	 *
	 */
	public int getRandomNum()
	{
		Random ran=new Random();
		int randomNum=ran.nextInt(1000);
		return randomNum;
	}
	
	public String getDateAndTime()
	{
		Date d=new Date();
		String dateAndTime=d.toString().replaceAll(":", "-");
		return dateAndTime;
	}

}
