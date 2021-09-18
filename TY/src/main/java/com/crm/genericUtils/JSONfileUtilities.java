package com.crm.genericUtils;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;


/**
 * This class contains methods to read data from json file
 * @author Bhanu
 *
 */
public class JSONfileUtilities {
	/**
	 * This method reads data from json file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromJSON(String key) throws Throwable
	{
		//read the data from json file
		FileReader file=new FileReader(IPathConstant.jsonPath);
		//convert the json file into java object
		JSONParser jsObj=new JSONParser();
		Object jObj = jsObj.parse(file);
		//typecast java object into hashmap
		HashMap map=(HashMap)jObj;
		String value = map.get(key).toString();
		//retuen the value
		return value;
	}

}
