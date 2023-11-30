package com.HungerMantra.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtils1;

public class AddMenuPage {

	
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
	
	public WebElement getDishNameTbx() {
		return dishNameTbx;
	}

	public void setDishNameTbx(WebElement dishNameTbx) {
		this.dishNameTbx = dishNameTbx;
	}

	public WebElement getAboutTbx() {
		return aboutTbx;
	}

	public void setAboutTbx(WebElement aboutTbx) {
		this.aboutTbx = aboutTbx;
	}

	public WebElement getPriceTbx() {
		return priceTbx;
	}

	public void setPriceTbx(WebElement priceTbx) {
		this.priceTbx = priceTbx;
	}

	public WebElement getImageFile() {
		return imageFile;
	}

	public void setImageFile(WebElement imageFile) {
		this.imageFile = imageFile;
	}

	public WebElement getRestaurantDD() {
		return restaurantDD;
	}

	public void setRestaurantDD(WebElement restaurantDD) {
		this.restaurantDD = restaurantDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(WebElement saveBtn) {
		this.saveBtn = saveBtn;
	}
	@FindBy(name="submit")
	private WebElement saveBtn;
	
	
	
	public AddMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void createMenu(String dishName,String about,String price,String imagePath,String restaurant,WebDriverUtils1 w)
	{
		dishNameTbx.sendKeys(dishName);
		aboutTbx.sendKeys(about);
		priceTbx.sendKeys(price);
		imageFile.sendKeys(imagePath);
		w.dropDownByVisibleText(restaurant, restaurantDD);
		saveBtn.click();
	}
	public String dishName(WebDriver driver,String DishName)
	{
		driver.findElement(By.xpath("//td[.='" + DishName + "']/..//i[@class='fa fa-edit']")).click();
		return DishName;
	}
	public String createMessage(WebDriver driver)
	{
		String createMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		return createMessage;
}
}
