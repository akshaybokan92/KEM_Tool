package com.kem.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) {

		ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\Akshay.Bokan\\git\\KEM_Tool\\KEM_Tool\\testdata\\Users.xlsx");

		System.out.println(excel.getData(0, 0, 0));
	}


}
