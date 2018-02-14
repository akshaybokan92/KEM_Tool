package com.kem.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.kem.resource.ConfigReader;

public class Constant {

	public static WebElement findElement(By locator, WebDriver driver) {
		ConfigReader cr = new ConfigReader();
		WebElement element = null;
		for (int i = 0; i < Integer.parseInt(cr.getConfigProperty("Max_Retry_Count")); i++) {
			try {
				Thread.sleep(1000);
				System.out.println("Utility.findElement :: Finding Element " + locator.toString() + " Try " + i);
				element = driver.findElement(locator);
				return element;
			} catch (NoSuchElementException | StaleElementReferenceException | InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Utility.findElement ::" + e.getMessage());
				System.out.println("Utility.findElement :: Element Not Found");
			}
		
		}
		return null;
	}

}
