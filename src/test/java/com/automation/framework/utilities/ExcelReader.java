package com.automation.framework.utilities;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	
	public static String readDataFromExcel(String testDataFilePath, String SheetName, int rowNum, int cellNum)
	{
		String text = null;
		try {
			
			File f = new File(testDataFilePath);
			Workbook wb = WorkbookFactory.create(f);
			Sheet mysheet = wb.getSheet(SheetName);
			Row myRow = mysheet.getRow(rowNum);
			Cell myCell = myRow.getCell(cellNum);
			text = myCell.getStringCellValue();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return text;
	}
	
	
	public static int getRowCount(String testDataFilePath, String SheetName)
	{
		int lastRowNum = 0;
		try {
			
			File f = new File(testDataFilePath);
			Workbook wb = WorkbookFactory.create(f);
			Sheet mysheet = wb.getSheet(SheetName);
			lastRowNum = mysheet.getLastRowNum();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return lastRowNum;
	}
	
}
