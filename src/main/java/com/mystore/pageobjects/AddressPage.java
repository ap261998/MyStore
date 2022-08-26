package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {

	@FindBy(xpath = "//*[text() = 'Proceed to checkout']")
	WebElement ProceedToCheckoutBtn;
	
	public AddressPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage clickOnCheckout()
	{
		Action.click(getDriver(), ProceedToCheckoutBtn);
		return new ShippingPage();
	}
}
