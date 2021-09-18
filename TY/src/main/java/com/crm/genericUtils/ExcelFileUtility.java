package com.crm.genericUtils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contains generic method to read data from excel sheet
 * @author Bhanu
 *
 */
public class ExcelFileUtility {
	/**
	 * this method read data from excel sheet
	 * @throws Throwable 
	 */
	public String getExcelData(String SheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		 Sheet sheet = wb.getSheet(SheetName);
		 DataFormatter format=new DataFormatter();
		  Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		
		String value=format.formatCellValue(cell);
		return value;
	}
	public Object[][] getExcelData(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		 Sheet sheet = wb.getSheet(SheetName);
		 int lastRow = sheet.getLastRowNum();
		 int lastCell = sheet.getRow(0).getLastCellNum();
		 
		 
		 Object[][] data = new Object[lastRow][lastCell];
		 
		 for(int i=0;i<lastRow;i++)
		 {
			 for(int j=0;j<lastCell;j++)
			 {
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue(); 
			 }
		 }
		 return data;
	}

}
