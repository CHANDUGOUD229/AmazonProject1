package com_qa_Amazon_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_qa_Amazon_Base.Testbase;

public class ShoppingCartPage extends Testbase 
{
	@FindBy(xpath = "//span[@class=\"nav-cart-icon nav-sprite\"]")
	WebElement cartIconClickElement;
	@FindBy(xpath = "//input[@name=\"proceedToRetailCheckout\"]")
	WebElement proceedToClick;
	
	public ShoppingCartPage() throws Exception
	{
		PageFactory.initElements(driver, this);	
	}

	
	public void clickOnCartIcon()
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",cartIconClickElement);
	}
	
	public boolean isDisplayShoppingPage()
	{
		return cartIconClickElement.isDisplayed();
	}
	
	public SignInPage clickOnProceedToBuy() throws Exception 
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",proceedToClick);
		
		return new SignInPage();
	}

}
