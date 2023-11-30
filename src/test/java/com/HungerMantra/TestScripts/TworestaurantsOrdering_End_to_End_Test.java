package com.HungerMantra.TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.GenericUtilities.UserBaseClass;
import com.HungerMantra.pom.UserCheck_Out_Page;
import com.HungerMantra.pom.UserHomePage;
import com.HungerMantra.pom.UserMenuPage;
import com.HungerMantra.pom.UserRestaurantPage;

public class TworestaurantsOrdering_End_to_End_Test extends UserBaseClass {

	@Test
	public void tworestaurantsOrdering_End_to_End_Test() throws IOException, InterruptedException {
		
		UserHomePage userhome=new UserHomePage(driver);
		String Expected = "Login";

		
		System.out.println("--- Login_Page_Test ---");

		wlib.waitForTitleToBeVisible(driver, 30, userhome.getHomepageVerify());
		String Actual = driver.getTitle();
		System.out.println(Actual);
		if (Actual.equalsIgnoreCase(Expected)) {
			System.out.println("home page is displayed");

		} else {
			System.out.println("testcase-----failed");
		}
		
		UserHomePage uh=new UserHomePage(driver);
		uh.restaurantModuleClick();
		UserRestaurantPage userrestaurant=new UserRestaurantPage(driver);

		String ResName1 = "Eataly";
		String ResName2 = "French Reso";
		
userrestaurant.restaurantclick(driver, ResName1);
		// adding to cart order1
String dish1 = "chicken pasta";
		userrestaurant.dishclick(driver, dish1);

		uh.restaurantModuleClick();

	userrestaurant.restaurantclick(driver, ResName2);

		// secondorder to cart

		String dish2 = "French onion soup";
userrestaurant.dishclick(driver, dish2);
		// carttext
		userrestaurant.cartTextOrders(driver);

		// checkout
	UserMenuPage usermenu=new UserMenuPage(driver);
	usermenu.checkOutBtn();

		// cod
	

		// ordernow
	UserCheck_Out_Page usercheckout=new UserCheck_Out_Page(driver);
	usercheckout.OrderBtnClick();

		wlib.switchToAlert(driver);
		wlib.alertPopUpAccept(driver);

		String confirmtext = wlib.alertPopUpText(driver);
		System.out.println(confirmtext);

		wlib.alertPopUpAccept(driver);
		String titleofOrderpage = driver.getTitle();

		String actualTitleOdersPage = "My Orders";

		if (titleofOrderpage.contains(actualTitleOdersPage)) {
			System.out.println("order placed");
		} else {
			System.out.println("not placed");
		}
		

	
	}
}
