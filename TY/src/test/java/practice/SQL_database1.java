package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SQL_database1 {
	public static void main(String[] args) throws SQLException {
		Driver drvref=new Driver();
		DriverManager.registerDriver(drvref);
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		Statement stat= con.createStatement();
		String query="insert into students_info (regno, firstname, middlename, lastname) values('5', 'dibya','jyoti', 'sahoo')";
		
		int result=stat.executeUpdate(query);
		if(result==1)
		{
			System.out.println("user created");
		}
		else
		{
			System.out.println("user not created");
		}
		con.close();
		

	}


}
