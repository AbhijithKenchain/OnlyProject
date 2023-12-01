
package com.HungerMantra.Restaurants;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.annotations.Test;

import com.GenericUtilities.AdminBaseClass;
import com.HungerMantra.pom.AddRestaurantPage;
import com.HungerMantra.pom.AdminDashBoardPage;
import com.HungerMantra.pom.AllRestaurantsPage;
import com.HungerMantra.pom.UpdateRestaurantPage;

public class EditDashboard_To_Allrestaurants_Admin_Integration_Test extends AdminBaseClass {

	@Test(groups={"Smoke","Regression"})
	public void editDashboard_To_Allrestaurants_Admin_Integration_Test() throws IOException, InterruptedException {

		

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
		admindash.restaurantDD();
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
		arp.cnclClick();
String resName = "ghj";
Thread.sleep(3000);
admindash.allrestaurantLink();
Thread.sleep(5000);

		AllRestaurantsPage allr=new AllRestaurantsPage();
		Thread.sleep(5000);
		allr.restaurantClick(driver, resName).click();

//updating resturant

		UpdateRestaurantPage u = new UpdateRestaurantPage(driver);

		String restName1 = elib.readFromExcelFile("Sheet3", 0, 1);
		String email1 = elib.readFromExcelFile("Sheet3", 1, 1);
		String phone1 = elib.readFromExcelFile("Sheet3", 2, 1);
		String url1 = elib.readFromExcelFile("Sheet3", 3, 1);
		String address1 = elib.readFromExcelFile("Sheet3", 4, 1);

		// openhours DD
		String openHours1 = elib.readFromExcelFile("Sheet4", 0, 0);

//closehoursDD
		String closeHours1 = elib.readFromExcelFile("Sheet4", 0, 1);

		String opendays1 = elib.readFromExcelFile("Sheet4", 0, 2);

		String category1 = elib.readFromExcelFile("Sheet4", 0, 3);

		String ImagePath1 = ("C:\\Users\\LENOVO\\eclipse-workspace\\com.ofos.HungerMantra\\src\\test\\resources\\Screenshotio.png");

		u.restaurantEdit(restName1, email1, phone1, url1, wlib, openHours1, closeHours1, opendays1, category1, ImagePath1,
				address1);

		String updateText = u.addRestaurantSuccessMessage(driver).getText();

		String ActualUpdatetext = "Record Updated!";
		if (updateText.contains(ActualUpdatetext)) {
			System.out.println("restaurant updated successfully");
		} else {
			System.out.println("restaurant not updated");

		}
		
		System.out.println("admin Logged out sucessfully");

		
		
	}

}
