package com_qa_Amazon_Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;





public class Testbase {
	public static	Properties prop;
	public static   WebDriver driver;
	public Testbase() throws Exception
	{
		try {
			prop =new Properties();
			FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com_qa_Amazon_Config\\or.properties");
			prop.load(fileInputStream);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialize() {
		String browsername=prop.getProperty("browser");
		System.out.println(browsername);
		//chrome
		if(browsername.equals("chrome")){  
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver=new ChromeDriver(); 	
		}
		else if (browsername=="ff") {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
			driver=new  FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public static void takeScreenshot() throws Exception {
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcfile, new File("D:\\Projects\\Amazon.com\\Amazon.com\\Screenshot\\ScrenShot"+generateDate()+".png"));
	}
	public static String generateDate() {
		Date d = new Date();
		SimpleDateFormat dFormat = new SimpleDateFormat("DD-MM-YYYY-hh-mm-ss");
		String ad = dFormat.format(d);
		return ad;
	}


}


