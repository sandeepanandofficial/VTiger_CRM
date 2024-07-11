package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactLookUpImage;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactLookUpImage() {
		return createContactLookUpImage;
	}
	
	/**
	 * This method will use to click on create contact look up image
	 */
	public void clickOnCreateContactLookUpImage()
	{
		createContactLookUpImage.click();
	}
}
