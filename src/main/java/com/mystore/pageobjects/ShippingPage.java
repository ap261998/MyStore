package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	@FindBy(id = "cgv")
	WebElement termsCheckBox;
	
	@FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
	WebElement proceedToCheckoutBtn;
	
	public ShippingPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnTerms()
	{
		Action.click(getDriver(),termsCheckBox);
	}
	
	public PaymentPage clickOnProceedToChecoutBtn()
	{
		Action.click(getDriver(),proceedToCheckoutBtn);
		return new PaymentPage();
	}
	

}
