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
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author akash
 *
 */
public class AddToCartPageTest extends BaseClass{
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	
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
	@Test(groups = {"Sanity", "Regression"})
	public void addToCartTest() throws Exception
	{
		indexpage = new IndexPage();
		searchresultpage = indexpage.searchProduct("t-shirt");
		addtocartpage = searchresultpage.clickOnProduct();
		addtocartpage.enterQuantity("2");
		addtocartpage.enterSize("M");
		addtocartpage.clickOnAddToCartBtn();
		boolean result = addtocartpage.validateAddToCart();
		Assert.assertTrue(result);
		
		
	}

	

}
