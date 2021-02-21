package com_qa_Amazon_Pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_qa_Amazon_Base.Testbase;

public class AddToCartPage extends Testbase
{
     //public WebDriver driver;
	
	
	@FindBy(xpath = "//*[@id='attach-sidesheet-view-cart-but']")
	WebElement cartElement;
	//@FindBy(id = "add-to-cart-button")
	@FindBy(id = "-to-cart")
	WebElement addToCartBtnElement;
	@FindBy(css = "img#landingImage")
	WebElement phoneImagElement;
	
	
	public AddToCartPage() throws Exception 
	{
		PageFactory.initElements(driver, this);
	 }
	public boolean isDisplayPhoneImg()
	{
		return phoneImagElement.isDisplayed();
	}
	
	
	
	public void clickOnAddToCart() throws InterruptedException
	{
		Thread.sleep(2000);
		addToCartBtnElement.click();
	}
	
	
	
	public ShoppingCartPage clickOnCart() throws Exception
	{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();",cartElement);
		 
		return new ShoppingCartPage();
	}
	

}
