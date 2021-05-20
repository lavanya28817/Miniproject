package com.TestNg_base;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import com.properties.Readconfig;

public class Baseclass {
	Readconfig con=new Readconfig();
	public String baseUrl=con.getApplicationURL();
	public String username=con.getUsername();
	public String password=con.getPassword();
	public static WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",con.getChromepath());
			driver=new ChromeDriver();
		}
		if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",con.getFirefoxpath());
			driver=new FirefoxDriver();
		}
		if(br.equals("IE")) {
			System.setProperty("webdriver.ie.driver",con.getIepath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get(baseUrl);
		
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	public void takeScreenshot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		String timestamp=new SimpleDateFormat("YYYY.MM.DD.HHMM.SS").format(new Date());
		String tname="screenshoot"+timestamp +".png";
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(System.getProperty("user.dir")+ "/Screenshot/" +tname);
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
