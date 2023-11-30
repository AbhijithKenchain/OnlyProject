package com.HungerMantra.Restaurants;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtilities.UserBaseClass;
import com.HungerMantra.pom.UserCheck_Out_Page;
import com.HungerMantra.pom.UserHomePage;
import com.HungerMantra.pom.UserMenuPage;
import com.HungerMantra.pom.UserRestaurantPage;
import com.HungerMantra.pom.YourOrdersPage;

public class CancelOrderedDish_End_to_End_Test extends UserBaseClass {

	@Test
	public void cancelOrderedDish_End_to_End_Test() throws IOException, InterruptedException {

		System.out.println("--- Login_Page_Test ---");

		String Actual = driver.getTitle();
		System.out.println(Actual);
		String Expected = "Login";
		if (Actual.equalsIgnoreCase(Expected)) {
			System.out.println("home page is displayed");

		} else {
			System.out.println("testcase-----failed");
		}

		UserHomePage uh = new UserHomePage(driver);
		uh.restaurantModuleClick();

		String ResName1 = "Eataly";
		String ResName2 = "French Reso";

		// clcicking on 1st restaurant
		UserRestaurantPage ur = new UserRestaurantPage(driver);
		ur.restaurantclick(driver, ResName1);

		String dish1 = "chicken pasta";
		// adding to cart order1 from restaurant1
		ur.dishclick(driver, dish1);

//clicking on restaurant webpage link again
		uh.restaurantModuleClick();

		// selecting 2nd restaurant
		ur.restaurantclick(driver, ResName2);

		String dish2 = "French onion soup";

//secondorder to cart
		ur.dishclick(driver, dish2);

//carttext of orders and syso of text present in cart 
		ur.cartTextOrders(driver);

//checkout
		UserMenuPage usermenu = new UserMenuPage(driver);

		usermenu.checkOutBtn();

		UserCheck_Out_Page usercheck = new UserCheck_Out_Page(driver);
//cod

		// usercheck.CodradioBtnClick();

//ordernow
		usercheck.OrderBtnClick();

		wlib.switchToAlert(driver);
		wlib.alertPopUpAccept(driver);

		String confirmtext = wlib.alertPopUpText(driver);
		System.out.println(confirmtext);

		wlib.alertPopUpAccept(driver);
		
		YourOrdersPage you=new YourOrdersPage();
//validate
		

		String ExpectedTitleOrdersPage = "My Orders";
you.myordersPageconfirmTitle(driver, ExpectedTitleOrdersPage);
		
//orderlist
		
		int beforecount = you.OrderList(driver);
		
		
		System.out.println("orders count before cancelling is ------>" + beforecount);
		
		

		String dish = "French onion soup";

		// delete dish
		you.deleteParticularDish(driver, dish);

		wlib.switchToAlert(driver);

		String cancelpopup = wlib.alertPopUpText(driver);
		System.out.println(cancelpopup);

		wlib.alertPopUpAccept(driver);

		int afterDeleteCount = you.OrderList(driver);
		System.out.println("orders count after deleting a order is --------->" + afterDeleteCount);
		
		you.cancelleddishAssert(beforecount, afterDeleteCount);

}
}
