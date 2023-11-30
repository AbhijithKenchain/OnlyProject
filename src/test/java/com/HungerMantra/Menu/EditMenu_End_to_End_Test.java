package com.HungerMantra.Menu;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import com.GenericUtilities.AdminBaseClass;
import com.HungerMantra.pom.AddMenuPage;
import com.HungerMantra.pom.AdminDashBoardPage;
import com.HungerMantra.pom.EditMenuPage;


public class EditMenu_End_to_End_Test extends AdminBaseClass {

	@Test(groups="Smoke")
	public void editMenu_End_to_End_Test() throws IOException {

		AdminDashBoardPage ad = new AdminDashBoardPage(driver);

		String Expected = "Admin Panel";

		wlib.waitForTitleToBeVisible(driver, 30, ad.getAdminHomePage());

		ad.loginMessage(driver, Expected);

		// menu
		AddMenuPage addmenu = new AddMenuPage(driver);

		ad.AddmenuLink();

		String dishName = elib.readFromExcelFile("Menuinput", 0, 1);
		String about = elib.readFromExcelFile("Menuinput", 1, 1);
		String price = elib.readFromExcelFile("Menuinput", 2, 1);
		String igPath = "C:\\Users\\LENOVO\\eclipse-workspace\\com.ofos.HungerMantra\\src\\test\\resources\\Screenshotio.png";
		String restaurantDD = elib.readFromExcelFile("MenuDD", 0, 0);
		
		addmenu.createMenu(dishName, about, price, igPath, restaurantDD, wlib);

		String successMessage = addmenu.createMessage(driver);
		String actualMessage = "New Dish Added Successfully";

		if (successMessage.contains(actualMessage)) {
			System.out.println("menu added sucessfully");
		} else {
			System.out.println("menu not added");
		}

		ad.allMenuLink();

		String DishName = "chicken pasta";

		addmenu.dishName(driver, DishName);

		String dishName1 = elib.readFromExcelFile("Menuinput", 0, 1);
		String about1 = elib.readFromExcelFile("Menuinput", 1, 1);
		String price1 = elib.readFromExcelFile("Menuinput", 2, 1);
		String igPath1 = "C:\\Users\\LENOVO\\eclipse-workspace\\com.ofos.HungerMantra\\src\\test\\resources\\Screenshotio.png";
		String restaurantDD1 = elib.readFromExcelFile("MenuDD", 0, 0);
		EditMenuPage em = new EditMenuPage(driver);
		em.updateMenu(dishName1, about1, price1, igPath1, restaurantDD1, wlib);

		String actualUpdateMessage = "Record Updated!";

		if (em.editUpdateMessage(driver).contains(actualUpdateMessage)) {
			System.out.println("menu updated sucessfully");
		} else {
			System.out.println("menu not updated");
		}
		
	}
}
