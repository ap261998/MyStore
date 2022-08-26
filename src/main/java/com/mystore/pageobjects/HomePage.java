/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;
import com.mystore.actiondriver.Action;

/**
 * @author akash
 *
 */
public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistory;
	
	@FindBy(xpath = "//span[text()='My wishlists']")
	WebElement wishList;
	
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateOrderHistory()
	{
		return Action.isDisplayed(getDriver(), orderHistory);
		
	}
	
	public boolean validatewishList()
	{
		return Action.isDisplayed(getDriver(), wishList);
	}
	
	public String getCurrentUrl()
	{
		String homePageURL = getDriver().getCurrentUrl();
		return homePageURL;
	}

}
