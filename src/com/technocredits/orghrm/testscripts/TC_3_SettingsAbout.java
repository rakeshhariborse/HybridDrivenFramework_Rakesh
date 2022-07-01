package com.technocredits.orghrm.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.DashboardPage;
import com.technocredits.orghrm.pages.LoginPage;

public class TC_3_SettingsAbout {
	
	@Test
	public void TC3_SettingsAbout() {
		
		LoginPage LoginPage = new LoginPage();
		DashboardPage DashboardPage = new DashboardPage();
		
		System.out.println("1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login");
		PredefinedActions.setUp();
		
		PredefinedActions.myLogIn();
		
		System.out.println("   VERIFY - URL");
		Assert.assertTrue(LoginPage.getCurrentURL().contains("dashboard"));
		System.out.println("   VERIFY - Title");
		Assert.assertEquals(LoginPage.getCurrentTitle(), "Employee Management");
		
		System.out.println("6.1 Mouse Hover on Profile and Click on setting icon on profile");
		DashboardPage.hoverOnProfilePicture();
		System.out.println("6.2 setting icon is displayed");
		DashboardPage.isSettingIconDisplayed();
		System.out.println("6.3 Click on setting icon on profile");
		DashboardPage.clickOnSettingIcon();
		
		System.out.println("7. Verify user menu total 2 options are displayed (About, Change Password) on after click on setting icon.");
		List<String> listOfExpectedOptionsTitles = new ArrayList<>();
		listOfExpectedOptionsTitles.add("Change Password");
		listOfExpectedOptionsTitles.add("About");
		System.out.println(listOfExpectedOptionsTitles);
		System.out.println(DashboardPage.getTitlesOfSettingOptions());
		
		Assert.assertEquals(DashboardPage.getNumberOfSettingOptions(), 2 , 
				"2 Widgets are not present, there are Only " + DashboardPage.getNumberOfSettingOptions() + " options displayed.");
		
		Assert.assertEquals(listOfExpectedOptionsTitles,DashboardPage.getTitlesOfSettingOptions());
		
		System.out.println("8. Click on About");
		DashboardPage.clickSettingOptionAbout();
		Assert.assertTrue(DashboardPage.isCompanyNameDisplayedInAbout());  //waiting till
		System.out.println("9. Verify Employee is more than 0");
		Assert.assertTrue(DashboardPage.isNonZeroEmployee());
		
		System.out.println("10. Verify the company details fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)");
		List<String> listOfExpectedAboutsOptionsTitles = new ArrayList<>();
		listOfExpectedAboutsOptionsTitles.add("Company Name");listOfExpectedAboutsOptionsTitles.add("Version");
		listOfExpectedAboutsOptionsTitles.add("Employees");listOfExpectedAboutsOptionsTitles.add("Users");
		listOfExpectedAboutsOptionsTitles.add("Renewal on");
		System.out.println(listOfExpectedAboutsOptionsTitles);
		System.out.println(DashboardPage.getTitlesOfAboutOptions());
		
		Assert.assertEquals(DashboardPage.getNumberOfAboutOptions(), 5 , 
				"5 options are not present, there are Only " + DashboardPage.getTitlesOfAboutOptions() + " options displayed.");
		
		Assert.assertEquals(listOfExpectedAboutsOptionsTitles,DashboardPage.getTitlesOfAboutOptions());
		
		System.out.println("11. Click on OK button on popup.");
		DashboardPage.clickOnOKOfAbout();	
	}	
}
