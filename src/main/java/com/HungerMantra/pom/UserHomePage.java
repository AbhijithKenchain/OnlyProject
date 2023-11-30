package com.HungerMantra.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	
	@FindBy(xpath="//a[contains(text(),'Home ')]")
	private WebElement homeLink;
	
	@FindBy(xpath="//a[contains(text(),'Restaurants ')]")
	private WebElement restaurantLink;
	
	@FindBy(xpath="//a[contains(text(),'My Orders')]")
	private WebElement myOrdersLink;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logOutLink;

	@FindBy(xpath="//a[@class='nav-link active']")
	private WebElement homepageVerify;
	
	
	public WebElement getHomepageVerify() {
		return homepageVerify;
	}

	public UserHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * clicks on home tab
	 */
	public void homeClick()
	{
		homeLink.click();
	}
	/**
	 * clicks on restaurants tab
	 */
	public void restaurantModuleClick()
	{
		restaurantLink.click();
	}
	/**
	 * clicks on my orders tab
	 */
	public void myOrdersClick()
	{
		myOrdersLink.click();
	}
	
	/**
	 * clicks on logout link
	 */
	public void logoutClick()
	{
		logOutLink.click();
	}
	
	
	
	
	
}
