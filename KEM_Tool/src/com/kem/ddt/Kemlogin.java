package com.kem.ddt;

import java.lang.System.Logger;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kem.resource.Kem_LoginPage;
import com.kem.utility.ExcelDataConfig;

public class Kemlogin {

	WebDriver driver;

	@Test(dataProvider="KemLoginData" )
	public void launchbrowser(String username, String password) throws InterruptedException {
		
		//Driver path
		System.setProperty("webdriver.chrome.driver","./Configuration/chromedriver.exe");
		
		//Launch browser
		
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get("http://35.164.157.128/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		//Test case steps
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).click();
		//Kem_LoginPage.login.txt_password(driver).click();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-btn")).click();
		Thread.sleep(2000);
		
	
		
		// Verification Point
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
		
		ExcelDataConfig config = new ExcelDataConfig("./testdata/Users.xlsx");
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
