package com.TestNG_pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpageobjects {
WebDriver ldriver;

	
	public Loginpageobjects(WebDriver rdriver)
	

{
		
ldriver=rdriver;
	
PageFactory.initElements(rdriver, this);
	
}

	@FindBy(id="txtUsername")
	@CacheLookup
    WebElement txtUserName;
	

	@FindBy(id="txtPassword")
	@CacheLookup
	WebElement txtPassword;

	
	@FindBy(id="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	
	@FindBy(xpath = "//*[@id=\"welcome\"]")
	@CacheLookup
	WebElement actualuser;

	
	
	@FindBy(xpath="//*[@id=\"welcome-menu\"]/ul/li[3]/a")
	@CacheLookup
     WebElement lnkLogout;
	
	
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	public void actual()
	{
		actualuser.click();
	}
	
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
