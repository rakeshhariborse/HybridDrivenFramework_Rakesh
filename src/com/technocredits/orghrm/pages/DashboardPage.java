package com.technocredits.orghrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

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
}
