package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	//public static WebDriver driver;
	
	// Declare ThreadLocal Driver because we are doing parallel execution
		public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
		
		@BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
		public void loadConfig()
		{
			ExtentManager.setExtent();
			DOMConfigurator.configure("log4j.xml");
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(
						System.getProperty("user.dir") + "\\Configuration\\config.properties");
				prop.load(ip);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static WebDriver getDriver() {
			// Get Driver from threadLocalmap
			return driver.get();
		}
	
	
	
	
	public static void launchApp(String browserName) {
		
		
		WebDriverManager.chromedriver().setup();
		//String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//set browser to threadlocalmap
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		}
		
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));
	}
	
	@AfterSuite
	public void afterSuite()
	{
		ExtentManager.endReport();
	}
	
	

	

}
