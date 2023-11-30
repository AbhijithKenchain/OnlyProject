package com.HungerMantra.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRestaurantPage {
	
	
	
	@FindBy(xpath="//a[.='Eataly']")
	private WebElement restaurantLink;

	
	public WebElement getRestaurantLink() {
		return restaurantLink;
	}


	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logOutLink;

	public UserRestaurantPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void restaurantclick(WebDriver driver,String restaurantName)
	{
		WebElement restoname = driver.findElement(By.xpath("//a[.='"+restaurantName+"']"));
		restoname.click();
	}
	public void dishclick(WebDriver driver,String dishName)
	{
		WebElement dish = driver.findElement(By.xpath("//a[.='"+dishName+"']/ancestor::div[@class='food-item']/descendant::input[@value='Add To Cart']"));
	dish.click();
	}
	public void cartTextOrders(WebDriver driver)
	{
		String cartText = driver.findElement(By.xpath("//div[@class='widget widget-cart']")).getText();
		System.out.println(cartText);
	}
	public List<WebElement> allrestaurantList(WebDriver driver)
	{
		List<WebElement> restaurants = driver.findElements(By.xpath("//h5"));
		return restaurants;
	}
	public void logOut()
	{
		logOutLink.click();
	}
}
