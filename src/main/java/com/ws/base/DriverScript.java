package com.ws.base;

import java.io.File;

/*
 * Class DriverScript
 * Desc: This class is responsible for managing all the driver instance across the project
 * use this driver reference in other classes where driver reference is needed. Don't create duplicate driver reference
 * Developed By:
 * Approved By:
 */
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverScript {
	
	public static WebDriver driver;
	static Properties prop;
	
	public DriverScript()
	{
		try
		{
			File file = new File("./src/test/resources/configfile/config.properties");
			FileInputStream fis = new FileInputStream(file);
		prop =	new Properties();
		prop.load(fis);
		}
		
	catch (Exception e) {
		System.out.println("unable to load the properties file");
		System.out.println(e.getMessage());
	}
		
	}
	
	public void initApplication()
	{
		String browser = prop.getProperty("browser");
		if(browser.trim().equalsIgnoreCase("chrome"))
		{
			System.out.println("browser in use: " +browser);
			driver = new ChromeDriver();
		}
		
		else if(browser.trim().equalsIgnoreCase("firefox"))
		{
			System.out.println("browser in use: " +browser);
			driver = new FirefoxDriver();
		
			}
		else if(browser.trim().equalsIgnoreCase("edge"))
		{
			System.out.println("browser in use: " +browser);
			driver = new EdgeDriver();
		
			}
		else
		{
			System.out.println("unsupported browser: please check the config file for supported browsers");
		}
		
		driver.quit();
		
	}
}
