package com.HungerMantra.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllRestaurantsPage {
	
	
	
	public WebElement restaurantClick(WebDriver driver,String resName)
	{
		  WebElement restName = driver.findElement(By.xpath(
				"//table[@id='example23']//td[.='"+resName+"']/following-sibling::td/a[@class='btn btn-info btn-flat btn-addon btn-sm m-b-10 m-l-5']"));
		return restName;
	}

}
