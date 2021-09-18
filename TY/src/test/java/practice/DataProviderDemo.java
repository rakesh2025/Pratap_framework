package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.genericUtils.ExcelFileUtility;

public class DataProviderDemo {
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelFileUtility el = new ExcelFileUtility();
		Object[][] val = el.getExcelData("sheet2");	
		return val;
	}  
	@Test(dataProvider="getData")
	public void demo(String Name,String category)
	{
		System.out.println(Name);
		System.out.println(category);
	}

}
