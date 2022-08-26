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
public class HomePageTest extends BaseClass {
	
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
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void wishListTest(String uname, String pswd)
    {
		Log.startTestCase("wishListTest");
    	indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		homepage=loginpage.login(uname,pswd);
		//homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homepage.validatewishList();
		Assert.assertTrue(result);
		Log.endTestCase("wishListTest");
    }
    

	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void orderHistoryTest(String uName, String pswd)
    {
		
		Log.startTestCase("orderHistoryTest");
    	indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homepage.validateOrderHistory();
		Assert.assertTrue(result);
		Log.endTestCase("orderHistoryTest");
    }

}
