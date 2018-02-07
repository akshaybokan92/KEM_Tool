package com.kem.ddt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kem.utility.ExcelDataConfig;

public class Kemlogin {

	WebDriver driver;

	@Test(dataProvider="KemLoginData" )
	public void launchbrowser(String username, String password) throws InterruptedException {
		
		//driver path
		System.setProperty("webdriver.chrome.driver","D:\\Eclipse Automation\\chromedriver.exe");
		
		//launch browser
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://35.164.157.128/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		//test case steps
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-btn")).click();
		// verification point
		Assert.assertTrue(driver.getTitle().contains("KEM"), "login failed");
		System.out.println("Login successful");


	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name="KemLoginData")
	public Object[][] passData()
	{
		
		ExcelDataConfig config = new ExcelDataConfig("E:\\LoginDetails.xlsx");
		int rows = config.getRowCount(0);
		Object [][] data = new Object [rows][2];
		try{
		for (int i=0; i<rows; i++) 
		{

			data[i][0]= config.getData(0, i, 0);
			data[i][1]= config.getData(0, i, 1);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return data;
	}

}
