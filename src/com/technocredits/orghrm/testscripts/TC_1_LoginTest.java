package com.technocredits.orghrm.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.DashboardPage;
import com.technocredits.orghrm.pages.LoginPage;

public class TC_1_LoginTest {

	@Test
	public void loginUIValidationTest() {
		
	}
	
	@Test
	public void loginTest() {
		
		LoginPage LoginPage = new LoginPage();
		DashboardPage DashboardPage = new DashboardPage();
		
		System.out.println("1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login");
		PredefinedActions.setUp();
		
		System.out.println("2. Verify Logo displayed on Login Page");
		Assert.assertTrue(LoginPage.isLogoDisplayed());
		 
		System.out.println("3. Verify Login Panel displayed on Login Page");
		Assert.assertTrue(LoginPage.isLoginPanelDisplayed());
		
		System.out.println("4. User able to enter username as your username");
		String username = "Admin";
		LoginPage.enterUsername(username);
		Assert.assertEquals(username, LoginPage.getEnteredUsernameStr(), "Entered username not matching");
		
		System.out.println("5. User able to enter password as your password");
		String password = "yQ6@1UCGfm";
		LoginPage.enterPassword(password);
		Assert.assertEquals(password, LoginPage.getEnteredPasswordStr(),"Entered password not matching");
		
		System.out.println("6. User click on Login button on Login Page");
		LoginPage.clickLoginButton();
		System.out.println("   VERIFY - URL");
		Assert.assertTrue(LoginPage.getCurrentURL().contains("dashboard"));
		System.out.println("   VERIFY - Title");
		Assert.assertEquals(LoginPage.getCurrentTitle(), "Employee Management");
		
		System.out.println("7. User should navigate to home page, Verify Employee Management header should be visible. ");
		Assert.assertTrue(DashboardPage.isTopBarTitleDisplayed());
		
		System.out.println("8. Verify total 9 widget's are disply on Dashboard page");
		Assert.assertEquals(DashboardPage.numberOfWidgets(), 9 , "9 Widgets are not present, there are Only " + DashboardPage.numberOfWidgets() + " widgets displayed.");
		
		System.out.println("9. Verify widget titles are displayed on Dashboard Page");
		List<String> listOfExpectedWidgetTitles = new ArrayList<>();
		listOfExpectedWidgetTitles.add("Quick Access");listOfExpectedWidgetTitles.add("Buzz Latest Posts");
		listOfExpectedWidgetTitles.add("My Actions");listOfExpectedWidgetTitles.add("Headcount by Location");
		listOfExpectedWidgetTitles.add("Employees on Leave Today");listOfExpectedWidgetTitles.add("Time At Work");
		listOfExpectedWidgetTitles.add("Latest Documents");listOfExpectedWidgetTitles.add("Latest News");
		//listOfExpectedWidgetTitles.add("COVID-19 Report");
		System.out.println(listOfExpectedWidgetTitles);
		System.out.println(DashboardPage.getWidgetsTitlesStr());
		Assert.assertEquals(listOfExpectedWidgetTitles,DashboardPage.getWidgetsTitlesStr());
	}
	
	@Test
	public void loginInvalidCredentailsTest() {

	}
	
}
