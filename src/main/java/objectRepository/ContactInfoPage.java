package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	@FindBy(className = "dvHeaderText")
	private WebElement contactHeaderText;
	
	//constructor
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//getter method
	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
	//Business Library - Generic Method related to Project
	/**
	 * This method will capture header text and return it to caller method
	 * @return
	 */
	public String captureContactHeader()
	{
		String contactHeader = contactHeaderText.getText();
		
		return contactHeader;
	}
}
