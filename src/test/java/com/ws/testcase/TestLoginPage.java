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
    	logger = report.createTest("Test Login Page");
		homePage.clickLoginLink();
		logger.pass("clicked login link");
		String title = loginPage.getLoginPageTitle();
		logger.pass("get the login page title");
		System.out.println("Page title: "+title);
		Assert.assertTrue(title.contains("Login"));	
		logger.pass("login page verification successfull");
		
	}
    
    @Test(priority =2)
    public void testLoginFunction() 
    {
    	logger = report.createTest("Test Login Function");
		homePage.clickLoginLink();
		logger.pass("clicked login link");
		loginPage.enterEmail("selauto1@test.com");
		logger.pass("entered username");
		loginPage.enterPassword("Pass@123");
		logger.pass("entered password");
		loginPage.clickloginButton();
		logger.pass("clicked login button");
		boolean flag = userHomepage.isLogoutLinkDisplayed();
		Assert.assertTrue(flag);
		userHomepage.clickLogout();
		logger.pass("login successfull");
			
    }
    
    public void testForgotPasswordDisplayed()
    {
    	logger = report.createTest("Test Forgot Password link is displayed");
    	homePage.clickLoginLink();
    	logger.pass("clicked login link");
    	boolean flag = loginPage.isforgotPasswordLinkDisplayed();
    	Assert.assertTrue(flag);
    	logger.pass("forgot password link is displayed");
    }
}
