package com_qa_Amazon_Testbase;

import org.testng.annotations.BeforeMethod;

import com_qa_Amazon_Base.Testbase;
import com_qa_Amazon_Pages.Homepage;
import com_qa_Amazon_Util.Excel_Reader;

public class AddToCartPageTest extends Testbase {
    Excel_Reader excel_Reader=new Excel_Reader(System.getProperty("user.dir")+"\\Testdata\\Amazondata.xlsx");
	   Homepage homepage;
	   SearchPagetest searchPagetest;
	  public AddToCartPageTest()  throws Exception{
		super();
	}
	 @BeforeMethod
	 public void setup() throws Exception {
		 initialize();
		 searchPagetest=new SearchPagetest();
		 
         homepage = new Homepage();
         
	 }
	 
}
