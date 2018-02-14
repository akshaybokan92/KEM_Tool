package com.kem.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties pro;

	public ConfigReader() {

		try {
			File src = new File("./Configuration/config.property");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

			String chromepath = pro.getProperty("ChromeDriver");
			System.out.println(chromepath);
		} catch (Exception e) {

			System.out.println("exception is.."+e.getMessage());
		}

	}

	public String getchromePath() {

		String path=pro.getProperty("Chromedriver");
		return path;



	}
	public String getApplicationUrl(){

		return pro.getProperty("URL");

	}

	public String getExcelPath(){

		return pro.getProperty("ExcelFilePath");

	}
	public String getConfigProperty(String a){

		return pro.getProperty(a);

	}


}
