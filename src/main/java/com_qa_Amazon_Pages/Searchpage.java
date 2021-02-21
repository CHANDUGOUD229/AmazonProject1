package com_qa_Amazon_Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_qa_Amazon_Base.Testbase;

   public class Searchpage extends Testbase {
   @FindBy(className="//*[@class='sb_3AXzcZxp']")
   WebElement img;
   
   @FindBy(xpath = "(//span[contains(text(),'New Apple iPhone 12 (128GB) - Blue')])[1]")
   WebElement lnkIphone128Gb;
   
   public Searchpage() throws Exception {
		PageFactory.initElements(driver, this);
   }
   
   public boolean isDisplayedIphone() {
	   	boolean	link=lnkIphone128Gb.isDisplayed();
	   return link;
   }
   
   public AddToCartPage clickIphoneLinke() throws Exception
   {
	   Thread.sleep(2000);
	   lnkIphone128Gb.click();
	 
			 Set<String> ids = driver.getWindowHandles();
		        Iterator<String> it = ids.iterator();
		        String parentId = it.next();
		        String childId = it.next();
		        driver.switchTo().window(childId);
		       
	   return new AddToCartPage();
   }
   
   
   
}