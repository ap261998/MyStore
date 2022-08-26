package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass{
	
	@FindBy(xpath = "//*[contains(text() , 'Pay by bank wire')]")
	WebElement payByBankWire;
	
	@FindBy(xpath = "//*[contains(text() , 'Pay by check')]")
	WebElement payByCheck;
	
	public PaymentPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummary clickOnPaymentsMethod()
	{
		Action.click(getDriver(), payByBankWire);
		return new OrderSummary();
	}
	
	
	
	

}
