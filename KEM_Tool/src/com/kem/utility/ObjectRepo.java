package com.kem.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;

public class ObjectRepo {
	
	public static final By.ById KEM_loginId_text= new ById("username");
	public static final By.ById KEM_loginpassword_text= new ById("password");
	public static final By.ById KEM_login_btn= new ById("login-btn");
}
