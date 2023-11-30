package com.HungerMantra.Menu;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtilities.AdminBaseClass;
import com.HungerMantra.pom.AddMenuPage;
import com.HungerMantra.pom.AdminDashBoardPage;


public class Addmenu_todashboard_dishes_integrationTest extends AdminBaseClass {

	
	@Test
	public  void addmenu_todashboard_dishes_integration_Test() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	
		
		String Expected="Admin";
		AdminDashBoardPage adp=new AdminDashBoardPage(driver);
		wlib.waitForTitleToBeVisible(driver, 30,adp.getAdminHomePage() );
		
		String Actual = driver.getTitle();
		System.out.println(Actual);
		if(Actual.contains(Expected))
		{
			System.out.println("admin homepage is displayed");
		}
		else
		{
			System.out.println("testcase failed");
		}
		
		String DishCount = adp.getMenuCount().getText();
		
		
		String dish=DishCount.replaceAll(",","");
		int value1=Integer.parseInt(dish);
		System.out.println(value1);
		
		//menu
		adp.menuDDclick();
		adp.AddmenuLink();
		String dishName = elib.readFromExcelFile("Menuinput", 0, 1);
		String about = elib.readFromExcelFile("Menuinput", 1, 1);
		String price=elib.readFromExcelFile("Menuinput", 2, 1);
		
		
		 AddMenuPage am=new AddMenuPage(driver);
		Thread.sleep(1000);
		String restaurantDD = elib.readFromExcelFile("MenuDD", 0, 0);
		wlib.dropDownByVisibleText(restaurantDD,am.getRestaurantDD());
		
		 
		 String imagePath  = "C:\\Users\\LENOVO\\eclipse-workspace\\com.ofos.HungerMantra\\src\\test\\resources\\Screenshotio.png";
		 
		
		 am.createMenu(dishName, about, price, imagePath, restaurantDD, wlib);
		
	String actualMessage="New Dish Added Successfully";
	
	if(am.createMessage(driver).contains(actualMessage))
	{
		System.out.println("menu added sucessfully");
	}
	else
	{
		System.out.println("menu not added");
	}
	

adp.getMenuDD().click();
adp.dashBoardPageLink();



//adp.getMenuCount().getText() comes from admin dashboard business logic
String dishes=adp.getMenuCount().getText().replaceAll(",","");
int countdishes=Integer.parseInt(dishes);
System.out.println(countdishes);

if(countdishes>value1)
{
	System.out.println("dish count updated successfully");
}
	
	else
	{
		System.out.println("dish count not updated ");
	}





}
}