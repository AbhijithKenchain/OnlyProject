		package com.GenericUtilities;
		
		import java.awt.AWTException;
import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.Select;
		import org.openqa.selenium.support.ui.WebDriverWait;
		
		public class WebDriverUtils1 {
		
			/**
			 * This maximises the browser to full screen
			 * @param driver
			 */
			public void maximizeWindows(WebDriver driver)
			{
				driver.manage().window().maximize();
			}
		
			/**
			 * this method minimizes the browser
			 * @param driver
			 */
			public void minimizeWindows(WebDriver driver)
			{
				driver.manage().window().minimize();
			}
			
			public void waitForPageLoad(WebDriver driver, int seconds)
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
				
			}
			
			public void waitForTitleToBeVisible(WebDriver driver, int seconds,WebElement element)
			{
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
				wait.until(ExpectedConditions.visibilityOf(element));
			}
			
			public void waituntilElementToBeClickable(WebDriver driver, int seconds,WebElement element)
			{
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
				wait.until(ExpectedConditions.elementToBeClickable(element));
			
			}
			public void implicitwait(WebDriver driver,int seconds)
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}
			
			public void waituntilElementToBeVisible(WebDriver driver, int seconds,WebElement element)
			{
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
				wait.until(ExpectedConditions.visibilityOf(element));
			
			}
			public void dropDownByIndex(WebElement element,int index)
			{
				Select s= new Select(element);
				s.selectByIndex(index);
			}
			
			public void dropDownByValue(WebElement element,String value)
			{
				Select s= new Select(element);
				s.selectByValue(value);
			}
			
			public void dropDownByVisibleText(String text,WebElement element)
			{
				Select s= new Select(element);
				s.selectByVisibleText(text);
			}
			
			public void dragAndDrop(WebDriver driver,WebElement source,WebElement target)
			{
				Actions a=new Actions(driver);
				a.dragAndDrop(source ,target).perform();
			}
		public void doubleClick(WebDriver driver)
		{
			Actions a= new Actions(driver);
			a.doubleClick().perform();
		}
		
		/**
		 * double clicks on element
		 * @param driver
		 * @param element
		 */
		public void doubleClick(WebDriver driver,WebElement element)
		{
			Actions a= new Actions(driver);
			a.doubleClick(element).perform();
		}
			/**
			 * right clicks on webpage
			 * @param driver
			 */
			public void rightClick(WebDriver driver)
			{
				Actions a= new Actions(driver);
				a.contextClick().perform();
			}
			/**
			 * right click on element present
			 * @param driver
			 * @param element
			 */
			public void rightClick(WebDriver driver,WebElement element)
			{
				Actions a= new Actions(driver);
				a.contextClick(element).perform();
			}
			
			/**
			 * actions class for sendKeys
			 * 
			 * @param driver
			 */
			public void keyPress(WebDriver driver)
			{
				Actions a= new Actions(driver);
						a.sendKeys(Keys.ENTER).perform();
				
			}
			
			/**
			 * for enter using robot class
			 * @throws AWTException
			 */
			public void keyPress() throws AWTException
			{
				Robot r= new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
				
			}
			/**
			 * releasing the enter button
			 * @throws AWTException
			 */
			public void keyRelease() throws AWTException
			{
				Robot r= new Robot();
				r.keyRelease(KeyEvent.VK_ENTER);
			}
			
			/**
			 * switch to frames using index
			 * @param driver
			 * @param index
			 */
			public void switchToFrames(WebDriver driver,int index)
			{
				driver.switchTo().frame(index);
			}
			/**
			 * switching to frame using name or id
			 * @param driver
			 * @param nameOrId
			 */
			public void switchToFrames(WebDriver driver,String nameOrId)
			{
				driver.switchTo().frame(nameOrId);
			}
			/**
			 * switching to frame using address
			 * @param driver
			 * @param address
			 */
			public void switchToFrames(WebDriver driver,WebElement address)
			{
				driver.switchTo().frame(address);
			}
			
			
			/**
			 * switch to windows using handle
			 * @param driver
			 * @param handle
			 */
			public void switchToWindows(WebDriver driver,String handle)
			{
				driver.switchTo().window(handle);
			}
			
			public void switchToAlert(WebDriver driver)
			{
				driver.switchTo().alert();
			}
			public void alertPopUpAccept(WebDriver driver)
			{
				driver.switchTo().alert().accept();
				
			}
			public void alertPopUpDismiss(WebDriver driver)
			{
				driver.switchTo().alert().dismiss();
			}
			public String alertPopUpText(WebDriver driver)
			{
				String text = driver.switchTo().alert().getText();
				
				return text;
			}
			/**
			 * disables notifications in chrome browser
			 */
			public void disableNotification()
			{
				ChromeOptions co=new ChromeOptions();
				co.addArguments("--disable-Notifications");
			}
			
			public void disableLocation()
			{
				ChromeOptions co=new ChromeOptions();
				co.addArguments("--disable-geolocation");
			}
			
			public void scrollBarFromTo(WebDriver driver)
			{
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,500)","");
			}
			
			public void scrollBarToElement(WebDriver driver,WebElement element,int y)
			{
				JavascriptExecutor js=(JavascriptExecutor)driver;
				 y=element.getLocation().getY();
				js.executeScript("window.scrollTo(0,"+y+")",element);
				js.executeScript("arguments[0].scrollIntoView(true);",element);
			}
			
			
			public void mouseHover(WebDriver driver,WebElement element)
			{
				Actions a= new Actions(driver);
				a.moveToElement(element).perform();
			}
			
			
			public String getTitle(WebDriver driver)
			{
				String title = driver.getTitle();
				return title;
				
			}
			
			public static String getScreenShot(WebDriver driver,String screenShotName) throws IOException
			{
				TakesScreenshot ts=(TakesScreenshot)driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest=new File(".//ScreenShot/"+screenShotName+".png");
				FileUtils.copyFile(src, dest);
				return dest.getAbsolutePath();
				
			}
			
			
			
			
			
			
			
			
		}
