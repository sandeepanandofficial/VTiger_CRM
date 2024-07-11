package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name="user_name")
	private WebElement userNameEdit;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getUserPasswordEdit() {
		return userPasswordEdit;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	/**
	 * This method is business library of this class -- create by using present element
	 * This method will login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void LoginToApplication(String USERNAME, String PASSWORD)
	{
		userNameEdit.sendKeys(USERNAME);
		userPasswordEdit.sendKeys(PASSWORD);
		loginButton.click();
	}
}
