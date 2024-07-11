package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumWebDriverUtility;

public class HomePage extends SeleniumWebDriverUtility{
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImage;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getAdministratorImage() {
		return administratorImage;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactsLink()
	{
		contactsLink.click();
	}
	
	/**
	 * This method will click on Organizations link
	 */
	public void clickOnOrganizationsLink()
	{
		organizationsLink.click();
	}
	
	/**
	 * This method will click on Leads link
	 */
	public void clickOnLeadsLink()
	{
		leadsLink.click();
	}
	
	/**
	 * This method will click on products link
	 */
	public void clickOnProductsLink()
	{
		productsLink.click();
	}
	
	/**
	 * This method will sign out from the application
	 * @param driver
	 * @throws InterruptedException
	 */
	public void signOutFromApplication(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver, administratorImage);
		Thread.sleep(1000);
		signoutLink.click();
	}
}
