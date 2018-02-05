package com.kem.ddt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kem.utility.ExcelDataConfig;

public class Kemlogin {

	WebDriver driver;

	@Test(dataProvider="KemLoginData" )

	public void launchbrowser(String username, String password) throws InterruptedException {
		driver = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver","D:\\Eclipse Automation\\geckodriver.exe");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("username");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login-btn")).click();

		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().contains("KEM"), "login failed");
		driver.get("http://35.164.157.128/");


	}

	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name="KemLoginData")

	public Object[][] passData()
	{
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\Akshay.Bokan\\git\\KEM_Tool\\KEM_Tool\\testdata\\Users.xlsx");
		
		int rows = config.getRowCount(0);
		
		Object [][] data = new Object [rows][2];

		for (int i=0; i<=rows; i++) {

			data[i][0]= config.getData(0, i, 0);
			data[i][1]= config.getData(0, i, 1);
		}
		return data;
	}

}
