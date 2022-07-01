package com.technocredits.orghrm.pages;

import com.technocredits.orghrm.base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPage extends PredefinedActions {
	
	//LOGO
	public boolean isLogoDisplayed() {
		try {
			return driver.findElement(By.xpath("//div[@class='organization-logo shadow']//img")).isDisplayed();
		}catch (NoSuchElementException nsee) {
			return false;
		}
	}
	
	
	//LOGIN PANEL
	public boolean isLoginPanelDisplayed() {
		try {
			return driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
		}catch (NoSuchElementException nsee) {
			return false;
		}
	}
	
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
		
	}
	
	//USERNAME
	public WebElement getUsernameWebE() {
		return driver.findElement(By.xpath("//input[@id='txtUsername']"));
	}
	public void enterUsername(String username) {
		getUsernameWebE().sendKeys(username);
	}
	public String getEnteredUsernameStr() {
		return getUsernameWebE().getAttribute("value");
	}
	
	//PASSWORD
	public WebElement getPasswordWebE() {
		return driver.findElement(By.xpath("//input[@id='txtPassword']"));
	}
	public void enterPassword(String password) {
		getPasswordWebE().sendKeys(password);
	}
	public String getEnteredPasswordStr() {
		return getPasswordWebE().getAttribute("value");
	}
	
	//SUBMIT BUTTON
	public void clickLoginButton() {
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}
	
	//URL
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	//TITLE
	public String getCurrentTitle() {
		return driver.getTitle();
	}
}
