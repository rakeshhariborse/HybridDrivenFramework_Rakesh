package com.technocredits.orghrm.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.technocredits.orghrm.pages.LoginPage;

public class PredefinedActions {
	
	protected static WebDriver driver;
	
	public static void setUp(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("STEP - Load URL => " + url);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void setUp() {
		setUp("https://rhborse-trials7501.orangehrmlive.com/");
	}
	
	public static void myLogIn() {
		LoginPage LoginPage = new LoginPage();
		String username = "Admin";
		String password = "yQ6@1UCGfm";
		
		System.out.println("2. [myLogIn] User able to enter username as your username");
		LoginPage.enterUsername(username);
		
		System.out.println("3. [myLogIn] User able to enter password as your password");
		LoginPage.enterPassword(password);
		
		System.out.println("4. [myLogIn] User click on Login button on Login Page");
		LoginPage.clickLoginButton();
		
	}
}
