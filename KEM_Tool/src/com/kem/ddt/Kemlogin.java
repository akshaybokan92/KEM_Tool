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

import com.kem.resource.ConfigReader;
import com.kem.resource.Kem_LoginPage;
import com.kem.resource.Kem_LoginPage.login;
import com.kem.utility.Constant;
import com.kem.utility.ExcelDataConfig;
import com.kem.utility.ObjectRepo;


public class Kemlogin 
{
	
	WebDriver driver;
	Kem_LoginPage klp = new Kem_LoginPage();
	ConfigReader cr = new ConfigReader(); 
	
	@Test(dataProvider="KemLoginData" )
	public void launchBrowser(String username, String password) throws InterruptedException 
	
	{
		
System.setProperty("webdriver.gecko.driver","./Configuration/geckodriver.exe");
		
		//launch browser
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver.get("http://35.164.157.128/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		//test case steps
		//Kem_LoginPage.login.txt_username(driver).sendKeys(username);
			//login.txt_username(driver).sendKeys(username);
		
		Constant.findElement(ObjectRepo.KEM_loginId_text, driver).sendKeys(username);
		Kem_LoginPage.login.txt_password(driver).click();
		
		Kem_LoginPage.login.txt_password(driver).sendKeys(password);
		Kem_LoginPage.login.txt_loginBtn(driver).click();

		Thread.sleep(3000);
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
		
		ExcelDataConfig config = new ExcelDataConfig("./testdata/Users.xlsx");
		int rows = config.getRowCount(0);
		Object [][] data = new Object [rows][2];
		try{
		for (int i=0; i<rows; i++) 
		{

			data[i][0]= config.getData(0, i, 0);
			data[i][1]= config.getData(0, i, 1);
		}
		
		} catch(Exception e) 
		
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return data;
	}

}
