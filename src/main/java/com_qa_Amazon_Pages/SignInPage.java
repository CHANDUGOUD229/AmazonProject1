package com_qa_Amazon_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_qa_Amazon_Base.Testbase;

public class SignInPage extends Testbase
{
	
	@FindBy(xpath = "//h1[contains(text(),\"Sign-In\")]")
	WebElement signInPage;
	
	public SignInPage()throws Exception
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isDisplaySignInPage()
	{
		return signInPage.isDisplayed();
	}
	
	

}
