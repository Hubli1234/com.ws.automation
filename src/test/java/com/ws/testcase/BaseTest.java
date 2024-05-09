package com.ws.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;
import com.ws.pages.UserHomePage;

public class BaseTest extends DriverScript {
	
	HomePage homePage;
	LoginPage loginPage;
	UserHomePage userHomepage;
	
	@BeforeMethod
	public void setUp()
	{
		initApplication();
		 homePage = new HomePage();
		 loginPage = new LoginPage();
		 userHomepage = new UserHomePage();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.quit();
	}

}
