/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author akash
 *
 */
public class LoginPageTest extends BaseClass{
	
     IndexPage indexpage;
     LoginPage loginpage;
     HomePage homepage;
     
     @Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser)
	{
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke", "Sanity"})
	public void loginTest(String uname, String pswd)
	{
		
		Log.startTestCase("loginTest");
		indexpage = new IndexPage();
		Log.info("User is going to click on signIn button");
		loginpage = indexpage.clickOnSignIn();
		Log.info("Enter username and password");
		//homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = loginpage.login(uname, pswd);
		String actualURL = homepage.getCurrentUrl();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Compare the expected and actual result");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is successfull");
		Log.endTestCase("loginTest");
	}

}
