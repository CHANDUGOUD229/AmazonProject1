package com_qa_Amazon_Testbase;



import java.security.PublicKey;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com_qa_Amazon_Base.Testbase;
import com_qa_Amazon_Pages.AddToCartPage;
import com_qa_Amazon_Pages.Searchpage;
import com_qa_Amazon_Pages.ShoppingCartPage;
import com_qa_Amazon_Pages.SignInPage;
import com_qa_Amazon_Util.Excel_Reader;

public class SearchPagetest extends Testbase
{
	Excel_Reader excel_Reader=new Excel_Reader(System.getProperty("user.dir")+"\\Testdata\\Amazondata.xlsx");
	HomePagetest homePagetest=new HomePagetest();
	Searchpage searchpage;
	AddToCartPage addToCartPage;
	ShoppingCartPage shoppingCartPage;
	SignInPage signInPage;
	String reportLocation="D:\\Projects\\Amazon.com\\Amazon.com\\Reports\\Reports.html";
	
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	public SearchPagetest() throws Exception
	{
		super();
	
	}
	@BeforeClass
	public  void setup() throws Exception {
	
		extentReports=new ExtentReports(reportLocation,true);
		extentTest=extentReports.startTest("setUp");
		homePagetest.setup();
		homePagetest.search();
		searchpage =new Searchpage();
		extentTest.log(LogStatus.PASS, "Test case Passed setup Test ");
	}
	@Test(priority = 1)
	public void verify_searchpage() throws Exception 
	{
		extentTest=extentReports.startTest("verify_searchpage");
		
		try {
		Assert.assertTrue(searchpage.isDisplayedIphone());
		extentTest.log(LogStatus.PASS, "Test case Passed verify_searchpage Test ");
		}catch (Exception e) {
			Testbase.takeScreenshot();
			e.printStackTrace();
		}
	}
	
	
	@Test(priority = 2)
	public void clickOnIphoneLink() throws Exception
	{
		extentTest=extentReports.startTest("clickOnIphoneLink");
		try {
		System.out.println(driver.getTitle());
		searchpage.clickIphoneLinke();
		extentTest.log(LogStatus.PASS, "Test case Passed clickOnIphoneLink Test ");
		}catch (Exception e) {
			Testbase.takeScreenshot();
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3)
	public void verifyAddToCartPage() throws Exception
	{
		extentTest=extentReports.startTest("verifyAddToCartPage");
		try {
			addToCartPage=new AddToCartPage();
		Assert.assertTrue(addToCartPage.isDisplayPhoneImg());
		extentTest.log(LogStatus.PASS, "Test case Passed verifyAddToCartPage Test ");
		}catch (Exception e) {
			
			Testbase.takeScreenshot();
			
		}
	}
	
	@Test(priority = 4)
	public void clickOnAddToCardBtn() throws Exception
	{
		extentTest=extentReports.startTest("clickOnAddToCardBtn");
		try {
			System.out.println(driver.getTitle());	
		addToCartPage.clickOnAddToCart();
				
		extentTest.log(LogStatus.PASS, "Test case Passed clickOnAddToCardBtn Test ");
		
		}catch (Exception e) {
			Testbase.takeScreenshot();
			e.printStackTrace();
		}
	}
	@Test(priority  = 5)
	public  void clickOnCartBtn() throws Exception
	{
		extentTest=extentReports.startTest("clickOnCartBtn");

		addToCartPage.clickOnCart();
		extentTest.log(LogStatus.PASS, "Test case Passed clickOnCartBtn Test ");
		
	}
	
	
	@Test(priority = 6)
	public void clickOnCartIcon() throws Exception
	{
		extentTest=extentReports.startTest("clickOnCartIcon");
		
		shoppingCartPage=new ShoppingCartPage();
		shoppingCartPage.clickOnCartIcon();
		extentTest.log(LogStatus.PASS, "Test case Passed clickOnCartIconImg Test ");
		
	}
	
	
	@Test(priority = 7)
	public void clickOnPrceedToBay() throws Exception
	{
		
		extentTest=extentReports.startTest("clickOnPrceedToBay");
		shoppingCartPage.clickOnProceedToBuy();
		extentTest.log(LogStatus.PASS, "Test case Passed clickOnPrceedToBay Test ");
		
	}
	@Test(priority = 8)
	public void verifySignInPage() throws Exception
	{
		
		extentTest=extentReports.startTest("verifySignInPage");
		signInPage=new SignInPage();
		Assert.assertTrue(signInPage.isDisplaySignInPage());
		extentTest.log(LogStatus.PASS, "Test case Passed verifySignInPage Test ");
		
	}
	
	
	@AfterClass
	public void teardown() throws Exception
	{
		
		extentTest=extentReports.startTest("teardown");
		Thread.sleep(2000);
		driver.quit();
		extentTest.log(LogStatus.PASS, "Test case Passed teardown Test ");
		extentReports.flush();
		extentReports.endTest(extentTest);
		
		}
		
	
	
}
