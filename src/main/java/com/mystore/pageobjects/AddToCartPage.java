package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {

	@FindBy(id = "quantity_wanted")
	WebElement quantity;
	
	@FindBy(id = "group_1")
	WebElement size;
	
	@FindBy(xpath = "//*[@name='Submit']")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]//h2/i")
	WebElement addToCartMessage;
	
	@FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]")
	WebElement checkoutBtn;
	
	public AddToCartPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String quantity1)
	{
		Action.type(quantity, quantity1);
	}
	
	public void enterSize(String size1)
	{
		Action.selectByVisibleText(size, size1);
	}
	
	public void clickOnAddToCartBtn()
	{
		Action.click(getDriver(), addToCartBtn);
		
	}
	
	public boolean validateAddToCart() throws Exception
	{
		Action.fluentWait(getDriver(), addToCartMessage, 10);
		return Action.isDisplayed(getDriver(), addToCartMessage);
	}
	
	public OrderPage clickOnCheckoutBtn() throws Exception
	{
		Action.fluentWait(getDriver(), checkoutBtn, 10);
		Action.JSClick(getDriver(), checkoutBtn);
		return new OrderPage();
	}
}
