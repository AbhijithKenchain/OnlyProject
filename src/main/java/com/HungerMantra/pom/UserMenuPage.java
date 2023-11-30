package com.HungerMantra.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMenuPage {

	
	@FindBy(xpath="//a[@class='btn btn-success btn-lg active']")
	private WebElement checkOutBtn;
	
	
	
	public UserMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void checkOutBtn()
	{
		checkOutBtn.click();
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

	
}
