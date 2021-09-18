package com.crm.genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

/**
 * this class contains generic method to read data from database
 * @author Bhanu
 *
 */
public class DatabaseUtility {
	Connection con=null;
	Driver driverref;
	/**
	 * established connection with database
	 * @throws Throwable 
	 */
	public void connectionToDB() throws Throwable
	{
		DriverManager.registerDriver(driverref);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	}
	
	/**
	 * close connection with database
	 * @throws Throwable 
	 */
	
	public void closeDB() throws Throwable
	{
		con.close();
	}
	
	/**
	 * this method return the data wrt column index
	 * @throws Throwable 
	 */
	public String getDataFromDB(String query,int columnIndex) throws Throwable
	{
		String value=null;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			
			value=result.getString(columnIndex);
		}
		return value;
	}
	

}
