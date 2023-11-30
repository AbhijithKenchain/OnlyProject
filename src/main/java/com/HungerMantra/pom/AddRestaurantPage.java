package com.HungerMantra.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtils1;

public class AddRestaurantPage {

	
	@FindBy(name="res_name")
	private WebElement restaurantNameTbx;
	
	@FindBy(name="email")
	private WebElement emailTbx;
	
	
	@FindBy(name="phone")
	private WebElement phoneTbx;
	
	@FindBy(name="url")
private WebElement WebsiteurlTbx;
	
	
	@FindBy(name="o_hr")
	private WebElement OpenHoursDD;
	
	@FindBy(name="c_hr")
	private WebElement closeHoursDD;
	
	@FindBy(name="o_days")
	private WebElement openDaysDD;
	
	@FindBy(name="c_name")
	private WebElement categoryDD;
	
	@FindBy(name="file")
	private WebElement imageFile;
	
	@FindBy(name="address")
	private WebElement addressEdit;


@FindBy(name="submit")
private WebElement saveBtn;

@FindBy(linkText="Cancel")
private WebElement CancelBtn;

public AddRestaurantPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void Addrestaurant(String resNameEdit,String emailEdit,String phoneEdit,String WebsiteEdit,WebDriverUtils1 w,String OpenHours,String CloseHours,String Opendays,String category,String imgPath,String addressEdits)
{
	restaurantNameTbx.sendKeys(resNameEdit);
	emailTbx.sendKeys(emailEdit);
	phoneTbx.sendKeys(phoneEdit);
	WebsiteurlTbx.sendKeys(WebsiteEdit);
	w.dropDownByVisibleText(OpenHours, OpenHoursDD);
	w.dropDownByVisibleText(CloseHours, closeHoursDD);
	w.dropDownByVisibleText(Opendays, openDaysDD);
	imageFile.sendKeys(imgPath);
	addressEdit.sendKeys(addressEdits);
	saveBtn.click();


}
public WebElement addRestaurantSuccessMessage(WebDriver driver)
{
	WebElement message = driver
	.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']"));
	return message;
}
public void cnclClick()
{
	CancelBtn.click();
}

}