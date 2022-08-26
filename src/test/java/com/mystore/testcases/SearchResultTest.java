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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author akash
 *
 */
public class SearchResultTest extends BaseClass{
	
	IndexPage indexpage;
    LoginPage loginpage;
    SearchResultPage searchresultpage;
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
	
	@Test(groups = "Smoke")
	public void productAvailabilityTest()
	{
		indexpage = new IndexPage();
		searchresultpage = indexpage.searchProduct("t-shirt");
		boolean result = searchresultpage.isProductAvailable();
		Assert.assertTrue(result);
	}
	

}
