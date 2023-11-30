package com.HungerMantra.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCheck_Out_Page {

	
	@FindBy(id="radioStacked1")
	private WebElement codRadioBtn;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement orderNowBtn;
	
	public UserCheck_Out_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void CodradioBtnClick()
	{
		codRadioBtn.click();
	}
	public void OrderBtnClick()
	{
		orderNowBtn.click();
	}
	
}
