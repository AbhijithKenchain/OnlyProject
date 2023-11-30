package com.HungerMantra.pom;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class YourOrdersPage {
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logOutLink;
	
	public int OrderList(WebDriver driver)
	{
		List<WebElement> Orderlist = driver.findElements(By.xpath("//td[@data-column='Item']"));
		int ordercount = Orderlist.size();
		
		
		//System.out.println("orders count before cancelling is ------>" + ordercount);
		return ordercount;
	}
	public void deleteParticularDish(WebDriver driver ,String dish)
	{
		driver.findElement(By.xpath(
				"(//td[@data-column='Item' and .=' "+dish+"'])[1]/..//i[@class='fa fa-trash-o']"))
				.click();
	}
	public void userLogOut()
	{
		logOutLink.click();
	}

	 public void myordersPageconfirmTitle(WebDriver driver, String ExpectedtitleofOrderPage)
	 {
		 String titleofOrderpage = driver.getTitle();

			Assert.assertEquals(titleofOrderpage, ExpectedtitleofOrderPage);
		
	 }
public void cancelleddishAssert(int beforecount,int afterDeleteCount )
{
	
	Assert.assertNotEquals(beforecount, afterDeleteCount,"value is not same");
}
			
	 }

