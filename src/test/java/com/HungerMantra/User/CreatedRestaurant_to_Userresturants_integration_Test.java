package com.HungerMantra.User;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.GenericUtilities.AdminBaseClass;
import com.GenericUtilities.UserBaseClass;
import com.HungerMantra.pom.AddRestaurantPage;
import com.HungerMantra.pom.AdminDashBoardPage;
import com.HungerMantra.pom.UserHomePage;
import com.HungerMantra.pom.UserRestaurantPage;

public class CreatedRestaurant_to_Userresturants_integration_Test extends AdminBaseClass {

	@Test
	public void createdRestaurant_to_Userresturants_integration_Test() throws IOException
	{
		String Expected = "Admin";

	AdminDashBoardPage admindash=new AdminDashBoardPage(driver);

	wlib.waitForTitleToBeVisible(driver, 20, admindash.getAdminHomePage());

	String Actual = driver.getTitle();
	System.out.println(Actual);
	if (Actual.contains(Expected)) {
		System.out.println("admin homepage is displayed");
	} else {
		System.out.println("testcase failed");
	}
	
	admindash.addrestaurantLink();

	AddRestaurantPage arp = new AddRestaurantPage(driver);

	String restName = elib.readFromExcelFile("Sheet1", 0, 1);
	String email = elib.readFromExcelFile("Sheet1", 1, 1);
	String phone = elib.readFromExcelFile("Sheet1", 2, 1);
	String url = elib.readFromExcelFile("Sheet1", 3, 1);
	String address = elib.readFromExcelFile("Sheet1", 4, 1);

	// openhours DD
	String openHours = elib.readFromExcelFile("Sheet2", 0, 0);

//closehoursDD
	String closeHours = elib.readFromExcelFile("Sheet2", 0, 1);

	String opendays = elib.readFromExcelFile("Sheet2", 0, 2);

	String category = elib.readFromExcelFile("Sheet2", 0, 3);

	String ImagePath = ("C:\\Users\\LENOVO\\eclipse-workspace\\com.ofos.HungerMantra\\src\\test\\resources\\Screenshotio.png");

	arp.Addrestaurant(restName, email, phone, url, wlib, openHours, closeHours, opendays, category, ImagePath,
			address);

	String alertText = arp.addRestaurantSuccessMessage(driver).getText();
	String actualText = "New Restaurant Added Successfully";

	if (alertText.contains(actualText)) {
		System.out.println("New Restaurant Added Successfully");
	} else {
		System.out.println("restaurant not added");

	}
	}
	

public class User extends UserBaseClass
{

@Test(dependsOnMethods = "createdRestaurant_to_Userresturants_integration_Test")
public void userModule() throws IOException
{
	




String Expected1="Login";

UserHomePage userhome=new UserHomePage(driver);
WebElement homepage = userhome.getHomepageVerify();

System.out.println("--- Login_Page_Test ---");

wlib.waitForTitleToBeVisible(driver, 30, homepage);
String Actual1 = driver.getTitle();
System.out.println(Actual1);
if (Actual1.equalsIgnoreCase(Expected1))
{
System.out.println("home page is displayed");


}
else
{
System.out.println("testcase-----failed");
}

userhome.restaurantModuleClick();

UserRestaurantPage userrest=new UserRestaurantPage(driver);
List<WebElement> allrestaurants = userrest.allrestaurantList(driver);

String restName = elib.readFromExcelFile("Sheet1", 0, 1);
for(WebElement allrest:allrestaurants)
{
	String resName = allrest.getText();

	if(resName.contains(restName))
	{
		System.out.println("resturant displayed in user module");
		break;
	}
	else
		
		
	{
		System.out.println("not displayed in user module");
	}
}


}
}
}


