package com.HungerMantra.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserWelcomeLoginPage {
	
	//declaration
	@FindBy(xpath="//a[.='Login']")
	private WebElement LoginLink;
	
	@FindBy (name="username")
	private WebElement UnTbx;
	
	@FindBy(name="password")
	private WebElement PwdTbx;
	
	@FindBy(id="buttn")
	private WebElement LgnBtn ;

	
	//initialization
	public UserWelcomeLoginPage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginLink() {
		return LoginLink;
	}


	public WebElement getUnTbx() {
		return UnTbx;
	}



	public WebElement getPwdTbx() {
		return PwdTbx;
	}

	
	public WebElement getLgnBtn() {
		return LgnBtn;
	}

	
	/**
	 * this method utilises which are available for
	 * @param username
	 * @param password
	 */
	
	//Utilization
	public void welcomeLogin(String Username,String Password)
	{
		LoginLink.click();
		UnTbx.sendKeys(Username);
		PwdTbx.sendKeys(Password);
		LgnBtn.click();
	}

}


