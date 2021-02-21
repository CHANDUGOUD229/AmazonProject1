package com_qa_Amazon_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_qa_Amazon_Base.Testbase;

public class Homepage extends Testbase {

	@FindBy(xpath="//*[@id='twotabsearchtextbox']")
	WebElement searchbox;
	
	@FindBy(xpath="//*[@id='suggestions-template']/div/div")
	WebElement options1st;
	
	public Homepage()  throws Exception {
		PageFactory.initElements(driver, this);
	}
	public String verifytitle() {
		String Homepagetitle=driver.getTitle();
		return Homepagetitle;
	}
 public String search( String data) throws Exception {
	 searchbox.sendKeys(data);
	 options1st.click();
	return data;
 }

}
