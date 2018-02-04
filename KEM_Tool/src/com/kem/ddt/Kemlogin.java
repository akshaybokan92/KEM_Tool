package com.kem.ddt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Kemlogin {
	
	WebDriver driver;
	
	@Test(dataProvider="KemLoginData" )
	public void launchbrowser(String username, String password) throws InterruptedException {
		
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("username");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login-btn")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().contains("home"), "login failed");
		
		
		
		
		driver.get("http://35.164.157.128/");
		
		
	}
	
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="KemLoginData")
	
	public Object[][] passData()
	{
		Object[][] data = new Object[6][2];
		
		data[0][0]="kem.modeler@gmail.com";
		data[0][1]="Password!123";
		return data;
		
	}

}
