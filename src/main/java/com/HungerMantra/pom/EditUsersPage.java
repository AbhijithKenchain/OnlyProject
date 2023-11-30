package com.HungerMantra.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUsersPage {

	
	@FindBy(name="uname")
	private WebElement UsernameTbx;
	
	@FindBy(name="fname")
	private WebElement FnameTbx;
	
	@FindBy(name="lname")
	private WebElement LnameTbx;
	
	@FindBy(name="email")
	private WebElement emailTbx;
	
	@FindBy(name="phone")
	private WebElement phoneTbx;
	
	@FindBy(name="submit")
private WebElement saveBtn;


@FindBy(xpath="//a[.='Cancel']")
private WebElement cancelBtn;


public EditUsersPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}


public void EditUserDetails(String UsernameEdit,String FirstNameEdit,String LastNameEdit,String emailEdit,String phoneEdit)
{
	UsernameTbx.sendKeys(UsernameEdit);
	FnameTbx.sendKeys(FirstNameEdit);
	LnameTbx.sendKeys(LastNameEdit);
	emailTbx.sendKeys(emailEdit);
	phoneTbx.sendKeys(phoneEdit);
	saveBtn.click();
	cancelBtn.click();
}






}
