package com.HungerMantra.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtils1;

public class EditMenuPage {
	
	
	@FindBy(name="d_name")
	private WebElement dishNameTbx;
	
	@FindBy(name="about")
	private WebElement aboutTbx;
	
	@FindBy(name="price")
	private WebElement priceTbx;
	
	@FindBy(name="file")
	private WebElement imageFile;
	
	@FindBy(name="res_name")
	private WebElement restaurantDD;
	
	@FindBy(xpath="//img[@alt='user']")
	private WebElement profilepic;
	
	@FindBy(xpath="//a[.=' Logout']")
	private WebElement logoutLink;
	
	@FindBy(name="submit")
	private WebElement saveBtn;
	public EditMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void updateMenu(String dishName,String about,String price,String imagePath,String restaurant,WebDriverUtils1 w)
	{
		dishNameTbx.sendKeys(dishName);
		aboutTbx.sendKeys(about);
		priceTbx.sendKeys(price);
		imageFile.sendKeys(imagePath);
		w.dropDownByVisibleText(restaurant, restaurantDD);
		saveBtn.click();
	}
	public void logout()
	{
		profilepic.click();
		logoutLink.click();
	}
	public String editUpdateMessage(WebDriver driver)
	{
		String updateMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		return updateMessage;
	}
}
