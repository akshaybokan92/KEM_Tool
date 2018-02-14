package com.kem.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Kem_LoginPage {

	public static class login{

		public static WebElement txt_username (WebDriver driver) 
		{
			WebElement element = null;
			element=driver.findElement(By.id("username"));
			return element;
		}

		public static WebElement txt_password(WebDriver driver)
		
		{
			WebElement element = null;
			element=driver.findElement(By.id("password"));
			return element;
		}

		public static WebElement txt_loginBtn(WebDriver driver)
		{
			WebElement element = null;
			element = driver.findElement(By.id("login-btn"));
			return element;
		}
	}
	
	public static class createRequestProject{
		
		public static WebElement txt_RpName(WebDriver driver)
		
		{
			WebElement element = null;
			element=driver.findElement(By.id("projectName"));
			return element;
		}
		
		
		
		
	}
}
