package com.Testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TestNG_pageObjects.Loginpageobjects;
import com.TestNg_base.Baseclass;


public class Login_testcase_001 extends Baseclass
{
public static Logger logger;
	@Test
	public void loginTest() throws IOException 
	{
			
		logger.info("URL is opened");
		
		Loginpageobjects lp=new Loginpageobjects(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
		    takeScreenshot();
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}
	

}
