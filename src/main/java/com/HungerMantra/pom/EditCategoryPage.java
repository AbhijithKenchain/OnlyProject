package com.HungerMantra.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCategoryPage {
	

	@FindBy(name="c_name")
	private WebElement categoryTbx;
	
	@FindBy(name="submit")
	private WebElement saveBtn;

	@FindBy(linkText="Cancel")
	private WebElement CancelBtn;
	
 public EditCategoryPage(WebDriver driver) 
	

	{
		PageFactory.initElements(driver, this);
	}
 
 
 public void addcategory(String categories)
 {
	 categoryTbx.sendKeys(categories);
	 saveBtn.click();
	 CancelBtn.click();
 }

}

