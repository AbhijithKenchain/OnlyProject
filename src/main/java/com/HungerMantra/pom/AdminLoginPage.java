package com.HungerMantra.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	
	@FindBy(name="username")
	private WebElement AdminUnTbx;
	
	
	@FindBy(name="password")
	private WebElement AdminPwdTbx;
	
	@FindBy(name="submit")
	private WebElement lgnBtn;
	
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void adminLogin(String AdminUsername,String AdminPassword)
	{
		AdminUnTbx.sendKeys(AdminUsername);
		AdminPwdTbx.sendKeys(AdminPassword);
		lgnBtn.click();
	}
	
	
}
