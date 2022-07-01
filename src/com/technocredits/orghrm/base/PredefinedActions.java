package com.technocredits.orghrm.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
}
