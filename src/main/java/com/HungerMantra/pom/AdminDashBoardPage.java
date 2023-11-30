package com.HungerMantra.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GenericUtilities.WebDriverUtils1;

public class AdminDashBoardPage {
	WebDriverUtils1 wlib=new WebDriverUtils1();
	@FindBy(xpath="//span[.='Dashboard']")
	private WebElement dashboardLink;
	
	@FindBy(xpath="//p[.='Restaurants']/../h2")
	private WebElement restaurantCount;
	
	
	@FindBy(xpath="//span[.='Users']")
	private WebElement AdminHomePage;
	
	public WebElement getDashboardLink() {
		return dashboardLink;
	}

	public WebElement getAdminHomePage() {
		return AdminHomePage;
	}

	public WebElement getRestaurant() {
		return RestaurantDD;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	public void loginMessage(WebDriver driver,String Expected)
	{
		String Actual = driver.getTitle();
		Assert.assertEquals(Actual, Expected);
	}
	@FindBy(xpath="//p[.='Dishes']/../h2")
	private WebElement menuCount;
	
	@FindBy(xpath="//p[.='Users']/../h2")
	private WebElement userCount;
	
	@FindBy(xpath="//p[.='Total Orders']/../h2")
	private WebElement totalOrdersCount;
	
	@FindBy(xpath="//p[.='Restro Categories']/../h2")
	private WebElement categoryCount;
	
	@FindBy(xpath="//p[.='Processing Orders']/../h2")
	private WebElement processingCount;
	
	@FindBy(xpath="//p[.='Delivered Orders']/../h2")
	private WebElement deliveredCount;
	
	@FindBy(xpath="//p[.='Cancelled Orders']/../h2")
	private WebElement cancelledcount;
	
	@FindBy(xpath="//p[.='Total Earnings']/../h2")
	private WebElement totalearnings;
	
	@FindBy(xpath="//span[.='Users']")
	private WebElement usersPageLink;
	
	@FindBy(xpath="//span[.='Restaurant']")
	private WebElement RestaurantDD;
	
	@FindBy(xpath="//a[.='All Restaurants']")
	private WebElement AllrestaurantPageLink;
	
	@FindBy(xpath="//a[.='Add Category']")
	private WebElement AddCategoryPageLink;
	
	@FindBy(xpath="//a[.='Add Restaurant']")
	private WebElement AddRestaurantPageLink;
	
	@FindBy(xpath="//span[.='Menu']")
	private WebElement MenuDD;
	
	@FindBy(xpath="//a[.='All Menues']")
	private WebElement AllMenusPageLink;
	
	@FindBy(xpath="//a[.='Add Menu']")
	private WebElement AddMenuPageLink;
	
	@FindBy(xpath="//a[.='Orders']")
	private WebElement OrdersPageLink;
	
	@FindBy(xpath="//img[@alt='user']")
	private WebElement profilepic;
	
	@FindBy(xpath="//a[.=' Logout']")
	private WebElement logoutLink;

	public WebElement getRestaurantCount() {
		return restaurantCount;
	}

	public WebElement getMenuCount() {
		return menuCount;
	}

	public WebElement getUserCount() {
		return userCount;
	}

	public WebElement getTotalOrdersCount() {
		return totalOrdersCount;
	}

	public WebElement getCategoryCount() {
		return categoryCount;
	}

	public WebElement getProcessingCount() {
		return processingCount;
	}

	public WebElement getDeliveredCount() {
		return deliveredCount;
	}

	public WebElement getCancelledcount() {
		return cancelledcount;
	}

	public WebElement getTotalearnings() {
		return totalearnings;
	}

	public WebElement getUsersPageLink() {
		return usersPageLink;
	}

	public WebElement getRestaurantDD() {
		return RestaurantDD;
	}

	public WebElement getAllrestaurantPageLink() {
		return AllrestaurantPageLink;
	}

	public WebElement getAddCategoryPageLink() {
		return AddCategoryPageLink;
	}

	public WebElement getAddRestaurantPageLink() {
		return AddRestaurantPageLink;
	}

	public WebElement getMenuDD() {
		return MenuDD;
	}

	public WebElement getAllMenusPageLink() {
		return AllMenusPageLink;
	}

	public WebElement getAddMenuPageLink() {
		return AddMenuPageLink;
	}

	public WebElement getOrdersPageLink() {
		return OrdersPageLink;
	}

	public WebElement getProfilepic() {
		return profilepic;
	}

	public WebElement getLogoutBtn() {
		return logoutLink;
	}
	
	public AdminDashBoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void logout()
	{
		profilepic.click();
		logoutLink.click();
	}
	
	public void OrderpageLink()
	{
		OrdersPageLink.click();
		
	}
	
	public void AddmenuLink()
	{
		
		AddMenuPageLink.click();
		
	}
	
	public void menuDDclick()
	{
		MenuDD.click();
	}
	
	public void allMenuLink()
	{

		AllMenusPageLink.click();
	}
	
	public void allrestaurantLink()
	{
		
		AllrestaurantPageLink.click();
	}
	
	public void addcategoryLink()
	{
		RestaurantDD.click();
		AddCategoryPageLink.click();
	}
	
	public void addrestaurantLink()
	{
		
		AddRestaurantPageLink.click();

	}
	public void dashBoardPageLink()
	{
		dashboardLink.click();
	}
	
	public void restaurantDD()
	{
		
		RestaurantDD.click();
	}
}
