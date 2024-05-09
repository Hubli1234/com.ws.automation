package com.ws.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;
import com.ws.pages.UserHomePage;

public class TestLoginPage extends BaseTest {
	
    @Test(priority = 1)
	public void testLoginPage() 
	{
		homePage.clickLoginLink();
		String title = loginPage.getLoginPageTitle();
		System.out.println("Page title: "+title);
		Assert.assertTrue(title.contains("Login"));	
		
	}
    
    @Test(priority =2)
    public void testLoginFunction() 
    {
		homePage.clickLoginLink();
		loginPage.enterEmail("selauto1@test.com");
		loginPage.enterPassword("Pass@123");
		loginPage.clickloginButton();
		boolean flag = userHomepage.isLogoutLinkDisplayed();
		Assert.assertTrue(flag);
		userHomepage.clickLogout();
		
		
    }
}
