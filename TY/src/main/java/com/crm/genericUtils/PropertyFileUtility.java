package com.crm.genericUtils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class contains generic method to read data from properties file
 * @author Bhanu
 *
 */
public class PropertyFileUtility {
	
	/**
	 * this method reads data from properties file
	 * @throws Throwable 
	 */
	public String getPropertiesFileData(String key) throws Throwable
	{
		FileInputStream fis =new FileInputStream(IPathConstant.propertyFilepath);
		Properties p= new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
		
	}
	

}
