package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of generic or reusable methods related to Selenium WebDriver
 * @author Sandeep Anand
 */

public class SeleniumWebDriverUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will full screen the window
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	/**
	 * This method will delete all cookies
	 * @param driver
	 */
	public void deleteAllCookies(WebDriver driver)
	{
		driver.manage().deleteAllCookies();
	}
	
	/**
	 * This method will set the size of the window
	 * @param driver
	 * @param width
	 * @param height
	 */
	public void setSizeOfWindow(WebDriver driver, int width, int height)
	{
		Dimension dimension = new Dimension(width,height);
		driver.manage().window().setSize(dimension);
	}
	
	/**
	 * This method will set the position of the window
	 * @param driver
	 * @param xAxis
	 * @param yAxis
	 */
	public void setPositionOfWindow(WebDriver driver, int xAxis, int yAxis)
	{
		Point point = new Point(xAxis, yAxis);
		driver.manage().window().setPosition(point);
	}
	
	/**
	 * This method will wait for 10 seconds for all web elements to load
	 * @param driver
	 */
	public void implicitlyWaitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 seconds for particular element to be visible
	 * @param driver
	 * @param element
	 */
	public void explicitlyWaitForElementToVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for 10 seconds for particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void explicitlyWaitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle drop down by using index
	 * @param element
	 * @param index
	 */
	public void handleDropDownByIndex(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * This method will handle drop down by using value
	 * @param element
	 * @param value
	 */
	public void handleDropDownByValue(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * This method will handle drop down by using Visible text
	 * @param element
	 * @param text
	 */
	public void handleDropDownByVisibleText(WebElement element, String visibleText)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method will perform mouse hover action on the particular web element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform right click action any where on the web page
	 * @param driver
	 */
	public void rightClickAtAnyWhereAction(WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.contextClick().perform();
	}
	
	/**
	 * This method will perform right click action on a particular web element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElementAction(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click action any where on the web page
	 * @param driver
	 */
	public void doubleClickAtAnyWhereAction(WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick().perform();
	}
	
	/**
	 * This method will perform double click action on a particular web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElementAction(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop action from source element to target element
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver, WebElement source, WebElement target)
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}
	
	/**
	 * This method will perform movement of cursor by offset and click
	 * @param driver
	 * @param xOffset
	 * @param yOffset
	 */
	public void moveCursorAndClickByOffset(WebDriver driver, int xOffset, int yOffset)
	{
		Actions actions = new Actions(driver);
		actions.moveByOffset(xOffset, yOffset).click().perform();
	}
	
	/**
	 * This method will perform movement of scroll down for 500 units
	 * @param driver
	 */
	public void scrollDownActions(WebDriver driver)
	{
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
		javaScriptExecutor.executeScript("window.ScrollBy(0,500);", "");
	}
	
	/**
	 * This method will perform movement of scroll up for 500 units
	 * @param driver
	 */
	public void scrollUpActions(WebDriver driver)
	{
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
		javaScriptExecutor.executeScript("window.ScrollBy(0,-500);", "");
	}
	
	/**
	 * This method will perform movement of scroll down until a particular web element
	 * @param driver
	 * @param element
	 */
	public void scrollDownUntilElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
		javaScriptExecutor.executeScript("argument[0].scrollIntoView();", element);
	}
	
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlertPopUp(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert popup
	 * @param driver
	 */
	public void dismissAlertPopUp(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will capture the text of alert popup and return to caller method
	 * @param driver
	 * @return alertPopUpText
	 */
	public String getTextOfAlertPopUp(WebDriver driver)
	{
		String alertPopUpText = driver.switchTo().alert().getText();
		return alertPopUpText;
	}
	
	/**
	 * This method will send data into alert popup
	 * @param driver
	 * @param text
	 */
	public void sendTextInAlertPopUp(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will handle frame by using index
	 * @param driver
	 * @param index
	 */
	public void handleFrameByIndex(WebDriver driver, int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This method will handle frame by using name or Id
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrameByNameOrId(WebDriver driver, String frameNameOrId)
	{
		driver.switchTo().frame(frameNameOrId);
	}
	
	/**
	 * This method will handle frame by using frameElement
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrameByElement(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method will switch to immediate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch to default or main page
	 * @param driver
	 */
	public void switchToDefaultContentFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will help to switch the control from one window to another window
	 * @param driver
	 * @param partialWindowName
	 */
	public void switchToWindows(WebDriver driver, String partialWindowName)
	{
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for(String IDs : allWindowIDs)
		{
			String actualTitle = driver.switchTo().window(IDs).getTitle();
			
			if(actualTitle.contains(partialWindowName))
			{
				break;
			}
		}
	}
	
	/**
	 * This method will help to take screenshot and store it in required folder
	 * @param driver
	 * @param screenShotName
	 * @return absolutePath	//--> Used for extent report
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenShotName) throws IOException
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File sourceLocation = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destinationLocation = new File(".\\Screenshot\\" + screenShotName + ".png");
		Files.copy(sourceLocation, destinationLocation);
		
		String absolutePath = destinationLocation.getAbsolutePath();
		return absolutePath;	//used for extent reporting
	}
}
