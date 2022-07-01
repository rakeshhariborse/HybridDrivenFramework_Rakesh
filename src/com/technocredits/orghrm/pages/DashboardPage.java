package com.technocredits.orghrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.technocredits.orghrm.base.PredefinedActions;

public class DashboardPage extends PredefinedActions{
	
	public WebElement getTopBarTitleWebE() {
		return driver.findElement(By.xpath("//div[text()='Employee Management']"));
	}
	
	public String getTopBarTitleStr() {
		return getTopBarTitleWebE().getText();
	}
	
	public boolean isTopBarTitleDisplayed() {
		try {
			return getTopBarTitleWebE().isDisplayed();
		}catch(NoSuchElementException nsee) {
			return false;
		}
	}
	
	//WIDGETS
	public List<WebElement> getWidgets(){
		List<WebElement> listOfWidgets = new ArrayList<>();
		listOfWidgets = driver.findElements(By.xpath("//div[@class='row']/div[not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]"));
		return listOfWidgets;
	}
	
	//NUMBER OF WIDGETS
	public int numberOfWidgets(){
		return getWidgets().size();
	}
	
	//TITLES OF WIDGETS
	public List<String> getWidgetsTitlesStr(){
		List<String> listOfWidgetsTitles = new ArrayList<>();
		for (WebElement widget : getWidgets()) {
			listOfWidgetsTitles.add(widget.getText());
		}
		return listOfWidgetsTitles;
	}
	
	public void hoverOnProfilePicture() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='image-container']//img"))).build().perform();
	}
	
	//SETTING ICON
	public WebElement getSettingIcon() {
		return driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']//i[text()='ohrm_settings']"));
	}
	public boolean isSettingIconDisplayed() {
		return getSettingIcon().isDisplayed();
	}
	public void clickOnSettingIcon() {
		getSettingIcon().click();
	}
	
	
	//SETTING OPTIONS
	public List<WebElement> getSettingOptionsList(){
		List<WebElement> listOfOptions = new ArrayList<>();
		listOfOptions = driver.findElements(By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']//div[@class='sub-menu-container']//a"));
		return listOfOptions;
	}
	
	//NUMBER OF SETTING OPTIONS
	public int getNumberOfSettingOptions(){
		return getSettingOptionsList().size();
	}
	
	//TITLES OF SETTING OPTIONS
	public List<String> getTitlesOfSettingOptions(){
		List<String> listOfOptionsTitles = new ArrayList<>();
		for (WebElement option : getSettingOptionsList()) {
			listOfOptionsTitles.add(option.getText().trim());
		}
		return listOfOptionsTitles;
	}
	
	public void clickSettingOptionChnagePassword(){
		getSettingOptionsList().get(0).click();
	}
	public void clickSettingOptionAbout(){
		getSettingOptionsList().get(1).click();
	}
	
	public boolean isCompanyNameDisplayedInAbout() {
		return driver.findElement(By.xpath("//p[contains(text(),'Company Name:')]")).isDisplayed();
	}
	
	//ABOUT OPTIONS
	public List<WebElement> getAboutOptionsList(){
		List<WebElement> listOfAboutOptions = new ArrayList<>();
		listOfAboutOptions = driver.findElements(By.xpath("//div[@id='companyInfo']//div[@class='row']//p"));
		return listOfAboutOptions;
	}
	
	//NUMBER OF ABOUT OPTIONS
	public int getNumberOfAboutOptions(){
		return getAboutOptionsList().size();
	}
	
	//TITLES OF ABOUT OPTIONS
	public List<String> getTitlesOfAboutOptions(){
		List<String> listOfOptionsTitles = new ArrayList<>();
		for (WebElement option : getAboutOptionsList()) {
			listOfOptionsTitles.add(option.getText().split(":")[0]);
		}
		return listOfOptionsTitles;
	}
	
	public boolean isNonZeroEmployee() {
		 String n = driver.findElement(By.xpath("//div[@id='companyInfo']//div[@class='row']//p[contains(text(),'Employee')]")).getText().split(" ")[1];
		 return Integer.parseInt(n)!=0;
	}
	
	public void clickOnOKOfAbout() {
		driver.findElement(By.id("heartbeatSubmitBtn")).click();
		
	}
	public void clickOnCancelOfAbout() {
		driver.findElement(By.id("heartbeatCancelBtn")).click();
	}
}
