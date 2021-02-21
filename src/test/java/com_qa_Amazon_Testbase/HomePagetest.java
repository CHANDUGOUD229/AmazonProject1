package com_qa_Amazon_Testbase;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_qa_Amazon_Base.Testbase;
import com_qa_Amazon_Pages.Homepage;
import com_qa_Amazon_Util.Excel_Reader;

public class HomePagetest extends Testbase {
    Excel_Reader excel_Reader=new Excel_Reader(System.getProperty("user.dir")+"\\Testdata\\Amazondata.xlsx");
	   Homepage homepage;
	   SearchPagetest searchPagetest;
	  public HomePagetest()  throws Exception{
		super();
	}
	 @BeforeMethod
	 public void setup() throws Exception {
		 initialize();
         homepage = new Homepage();
	 }

	 @Test
	 public SearchPagetest search() throws Exception 
	 {
		 try {
			 homepage.search(excel_Reader.getdata("Sheet1", 1, 1));
		} catch (Exception e) {
			Testbase.takeScreenshot();
		}
	return new SearchPagetest();
	 }
	 @AfterMethod
	 public void teardown() {
			driver.quit();
	 }
}
