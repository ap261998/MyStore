package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(id = "search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name= "submit_search")
	WebElement submitSearchBtn;	
	
	public IndexPage()      //It will initialize the page objects of this class,when we create object of this class index page so automatically this constructor will be called and this will initialize
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	// This below method will return the login page object, When it will click on signIn button then we will land on login page
	public LoginPage clickOnSignIn()
	{
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo()
	{
		return Action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle()
	{
		String myStoreTitle=getDriver().getTitle();
		return myStoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName)
	{
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), submitSearchBtn);
		return new SearchResultPage();
	}
}
