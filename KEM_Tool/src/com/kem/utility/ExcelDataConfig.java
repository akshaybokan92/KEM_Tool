package com.kem.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	
	public ExcelDataConfig()  {
		
		try {
			File scr = new File("");
			FileInputStream fis = new FileInputStream(scr);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet1 =   wb.getSheetAt(0);
		}  catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	
		
		
		
		
		
		
		
		
	}
	public String getData(int sheetNumber,int row, int column) {
		
		String data= sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
		
		
		
	}
	
	
	public int getRowCount(int sheetIndex)
	{
		wb.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
		return row;
		
	}
}
