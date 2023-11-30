package com.GenericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.HungerMantra.pom.AdminDashBoardPage;
import com.HungerMantra.pom.AdminLoginPage;

public class AdminBaseClass {

	public DataBaseUtils dlib = new DataBaseUtils();
	public FileUtils flib = new FileUtils();
	public WebDriverUtils1 wlib = new WebDriverUtils1();
	public ExcelUtils elib = new ExcelUtils();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void connectDB() throws SQLException, InterruptedException {
		dlib.dataBaseConnection();
		System.out.println("-----connected DB------");
		Thread.sleep(5000);	}

	// @Parameters("AdminBrowser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws IOException, InterruptedException {
		String AdminBrowser = flib.readFromPropertyFile("AdminBrowser");

		if (AdminBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("-------------open Browser------------");
			Thread.sleep(5000);
		} else if (AdminBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("invalid browser");
		}
		sdriver = driver;
		wlib.maximizeWindows(driver);
		
	}

	@BeforeMethod(alwaysRun = true)
	public void adminLogin() throws IOException {
		String AdminUrl = flib.readFromPropertyFile("AdminUrl");
		String AdminUsername = flib.readFromPropertyFile("AdminUsername");
		String AdminPassword = flib.readFromPropertyFile("AdminPassword");

		AdminLoginPage al = new AdminLoginPage(driver);
		driver.get(AdminUrl);
		wlib.waitForPageLoad(driver, 30);
		wlib.implicitwait(driver, 30);
		al.adminLogin(AdminUsername, AdminPassword);
		System.out.println("------------login successfull--------------");

	}

	@AfterMethod(alwaysRun = true)
	public void logout() {
		AdminDashBoardPage admindashboard = new AdminDashBoardPage(driver);
		admindashboard.logout();
		System.out.println("---------logout-----------");
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		System.out.println("----browser closed------");
	}

	@AfterSuite(alwaysRun = true)
	public void closeDB() throws SQLException {
		dlib.disConnect();
		System.out.println("-----------DB Disconnected---------");
	}
}
