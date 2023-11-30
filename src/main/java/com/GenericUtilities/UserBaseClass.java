package com.GenericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.HungerMantra.pom.UserHomePage;
import com.HungerMantra.pom.UserWelcomeLoginPage;

public class UserBaseClass {
	
	public DataBaseUtils dlib=new DataBaseUtils();
	public FileUtils flib=new FileUtils();
	public WebDriverUtils1 wlib=new WebDriverUtils1();
	public ExcelUtils elib=new ExcelUtils();
	public WebDriver driver;
	
	
	@BeforeSuite
	public void connectDB() throws SQLException
	{
		dlib.dataBaseConnection();
		System.out.println("-----connected DB------");
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException
	{
		String browser = flib.readFromPropertyFile("Browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("----invalid browser------");
		}
		wlib.maximizeWindows(driver);
		System.out.println("-------------open Browser------------");
	}
	
	
	@BeforeMethod
	public void UserLogin() throws IOException {
		String Url = flib.readFromPropertyFile("Url");
		String Username = flib.readFromPropertyFile("Username");
		String Password = flib.readFromPropertyFile("Password");
		
		UserWelcomeLoginPage userlog=new UserWelcomeLoginPage(driver);
		driver.get(Url);
		wlib.waitForPageLoad(driver, 30);
		wlib.implicitwait(driver, 30);
		userlog.welcomeLogin(Username, Password);
		System.out.println("------------login successfull--------------");
	
	}
	
	@AfterMethod
	public void logout()
	{
		UserHomePage userhome=new UserHomePage(driver);
		userhome.logoutClick();
		
		System.out.println("---------logout-----------");
		driver.getTitle();
	}
@AfterClass
public void closeBrowser()
{
	driver.quit();
	System.out.println("----browser closed------");
}
@AfterSuite
public void closeDB() throws SQLException
{
	dlib.disConnect();
	System.out.println("-----------DB Disconnected---------");
}
}

