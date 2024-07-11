package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumWebDriverUtility;

public class CreateNewContactsPage extends SeleniumWebDriverUtility{
	
	@FindBy(name = "salutationtype")
	private WebElement prefixDropDown;
	
	@FindBy(name = "firstname")
	private WebElement firstNameEdit;
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdit;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement organizationLookUpImage;
	
	@FindBy(id = "search_txt")
	private WebElement organizationsSearchEdit;
	
	@FindBy(name = "search")
	private WebElement organizationSearchButton;
	
	@FindBy(name = "leadsource")
	private WebElement leadsourceDropDown;
	
	@FindBy(id="title")
	private WebElement titleEdit;
	
	@FindBy(id="department")
	private WebElement departmentEdit;
	
	@FindBy(id="email")
	private WebElement emailEdit;
	
	@FindBy(id="assistant")
	private WebElement assistantEdit;
	
	@FindBy(id="assistantphone")
	private WebElement assistantPhoneEdit;
	
	@FindBy(name="emailoptout")
	private WebElement emailoptoutCheckBox;
	
	@FindBy(name="reference")
	private WebElement referenceCheckBox;
	
	@FindBy(name="notify_owner")
	private WebElement notify_ownerCheckBox;
	
	@FindBy(id="phone")
	private WebElement officePhoneEdit;
	
	@FindBy(id="mobile")
	private WebElement mobileEdit;
	
	@FindBy(id="homephone")
	private WebElement homephoneEdit;
	
	@FindBy(id="otherphone")
	private WebElement otherphoneEdit;
	
	@FindBy(id="fax")
	private WebElement faxEdit;
	
	@FindBy(id="jscal_trigger_birthday")
	private WebElement birthdayTableEdit;
	
	@FindBy(id="jscal_field_birthday")
	private WebElement birthdayFieldEdit;
	
	@FindBy(xpath = "//input[@name='contact_name']/following-sibling::img[@title='Select']")
	private WebElement reportsToLookUpImage;
	
	@FindBy(id="search_txt")
	private WebElement reportsToContactsSearchEdit;
	
	@FindBy(name="search")
	private WebElement reportsToContactsSearchButton;
	
	@FindBy(id="secondaryemail")
	private WebElement secondaryEmailEdit;
	
	@FindBy(name="donotcall")
	private WebElement donotcallCheckBox;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//Constructor
	
	public CreateNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Getters methods
	
	public WebElement getPrefixDropDown() {
		return prefixDropDown;
	}
	
	public WebElement getFirstNameEdit() {
		return firstNameEdit;
	}

	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getOrganizationLookUpImage() {
		return organizationLookUpImage;
	}

	public WebElement getOrganizationsSearchEdit() {
		return organizationsSearchEdit;
	}

	public WebElement getOrganizationSearchButton() {
		return organizationSearchButton;
	}

	public WebElement getLeadsourceDropDown() {
		return leadsourceDropDown;
	}

	public WebElement getTitleEdit() {
		return titleEdit;
	}

	public WebElement getDepartmentEdit() {
		return departmentEdit;
	}

	public WebElement getEmailEdit() {
		return emailEdit;
	}

	public WebElement getAssistantEdit() {
		return assistantEdit;
	}

	public WebElement getAssistantPhoneEdit() {
		return assistantPhoneEdit;
	}

	public WebElement getEmailoptoutCheckBox() {
		return emailoptoutCheckBox;
	}

	public WebElement getReferenceCheckBox() {
		return referenceCheckBox;
	}

	public WebElement getNotify_ownerCheckBox() {
		return notify_ownerCheckBox;
	}

	public WebElement getOfficePhoneEdit() {
		return officePhoneEdit;
	}

	public WebElement getMobileEdit() {
		return mobileEdit;
	}

	public WebElement getHomephoneEdit() {
		return homephoneEdit;
	}

	public WebElement getOtherphoneEdit() {
		return otherphoneEdit;
	}

	public WebElement getFaxEdit() {
		return faxEdit;
	}

	public WebElement getBirthdayTableEdit() {
		return birthdayTableEdit;
	}

	public WebElement getBirthdayFieldEdit() {
		return birthdayFieldEdit;
	}

	public WebElement getReportsToLookUpImage() {
		return reportsToLookUpImage;
	}

	public WebElement getReportsToContactsSearchEdit() {
		return reportsToContactsSearchEdit;
	}

	public WebElement getReportsToContactsSearchButton() {
		return reportsToContactsSearchButton;
	}

	public WebElement getSecondaryEmailEdit() {
		return secondaryEmailEdit;
	}

	public WebElement getDonotcallCheckBox() {
		return donotcallCheckBox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business Library
	
	/**
	 * This method will help to create contacts with mandatory fields
	 * @param LASTNAME
	 */
	public void createNewContactsWithMandatoryFields(String LASTNAME)
	{
		lastNameEdit.sendKeys(LASTNAME);
		saveButton.click();
	}
	
	/**
	 * This method will help to create new contacts with string text
	 * @param FIRSTNAME
	 * @param LASTNAME
	 * @param TITLE
	 * @param DEPARTMENT
	 * @param EMAIL
	 * @param ASSISTANT
	 * @param FAX
	 * @param SECONDARY_EMAIL
	 */
	public void createNewContactsWithStringText(String FIRSTNAME, String LASTNAME, String TITLE, String DEPARTMENT, String EMAIL, String ASSISTANT, String FAX, String SECONDARY_EMAIL)
	{
		firstNameEdit.sendKeys(FIRSTNAME);
		lastNameEdit.sendKeys(LASTNAME);
		titleEdit.sendKeys(TITLE);
		departmentEdit.sendKeys(DEPARTMENT);
		emailEdit.sendKeys(EMAIL);
		assistantEdit.sendKeys(ASSISTANT);
		faxEdit.sendKeys(FAX);
		secondaryEmailEdit.sendKeys(SECONDARY_EMAIL);
		saveButton.click();
	}
	
	/**
	 * This method will help to create new contacts with number text
	 * @param LASTNAME
	 * @param ASSISTANT_PHONE
	 * @param OFFICE_PHONE
	 * @param MOBILE
	 * @param HOME_PAGE
	 * @param OTHER_PHONE
	 */
	public void createNewContactsNumberText(String LASTNAME, String ASSISTANT_PHONE, String OFFICE_PHONE, String MOBILE, String HOME_PAGE, String OTHER_PHONE)
	{
		lastNameEdit.sendKeys(LASTNAME);
		assistantPhoneEdit.sendKeys(ASSISTANT_PHONE);
		officePhoneEdit.sendKeys(OFFICE_PHONE);
		mobileEdit.sendKeys(MOBILE);
		homephoneEdit.sendKeys(HOME_PAGE);
		otherphoneEdit.sendKeys(OTHER_PHONE);
		saveButton.click();
	}
	
	/**
	 * This method will help to create new contacts with organizations and report to window
	 * @param LASTNAME
	 * @param driver
	 * @param ORGANIZATION
	 * @throws InterruptedException 
	 */
	public void createNewContactsWithWindows(String LASTNAME, WebDriver driver, String ORGANIZATION, String REPORTTO) throws InterruptedException
	{
		lastNameEdit.sendKeys(LASTNAME);
		
		organizationLookUpImage.click();
		switchToWindows(driver, "Accounts");
		organizationsSearchEdit.sendKeys(ORGANIZATION);
		organizationSearchButton.click();
		driver.findElement(By.linkText(ORGANIZATION)).click();
//		driver.findElement(By.xpath("//a[.='" + ORGANIZATION + "']")).click();	// ---> Dynamic XPATH
		switchToWindows(driver, "Contacts");
		
		Thread.sleep(2000);
		
		reportsToLookUpImage.click();
		switchToWindows(driver, "Contacts&action");
		reportsToContactsSearchEdit.sendKeys(REPORTTO);
		reportsToContactsSearchButton.click();
		driver.findElement(By.linkText(REPORTTO)).click();
//		driver.findElement(By.xpath("//a[text()='" + REPORTTO + "']")).click();	 // --> Dynamic XAPTH
		switchToWindows(driver, "Contacts");
		
		saveButton.click();
	}
	
	/**
	 * This method will help to create new contacts with leadsource and prefix dropdown
	 * @param LASTNAME
	 * @param LEADSOURCE
	 */
	public void createNewContactsWithDropDown(String LASTNAME, String LEADSOURCE, String PREFIX)
	{
		lastNameEdit.sendKeys(LASTNAME);
		
		handleDropDownByValue(leadsourceDropDown, LEADSOURCE);
		
		handleDropDownByValue(prefixDropDown, PREFIX);
		
		saveButton.click();
	}
	
	/**
	 * This method will help to create new contacts with checkbox
	 * @param LASTNAME
	 */
	public void createNewContactsWithCheckBoxAndBirthday(String LASTNAME, String BIRTHDAY)
	{
		lastNameEdit.sendKeys(LASTNAME);
		birthdayFieldEdit.sendKeys(BIRTHDAY);
		emailoptoutCheckBox.click();
		referenceCheckBox.click();
		notify_ownerCheckBox.click();
		donotcallCheckBox.click();
		saveButton.click();
	}
	
	/**
	 * This method will help to create new contacts with birthday
	 * @param LASTNAME
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void createNewContactsWithBirthday(String LASTNAME, WebDriver driver) throws InterruptedException
	{
		lastNameEdit.sendKeys(LASTNAME);
		
		birthdayTableEdit.click();
		while(true)
		{
			try
			{
				driver.findElement(By.xpath("(//td[text()='July, 2023'])[2]/ancestor::thead/following-sibling::tbody/child::tr[3]/child::td[.='10']")).click();
				Thread.sleep(1000);
				System.out.println("2021-07-26 is selected");
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[@class='calendar']/child::table/child::thead/child::tr[2]/child::td[1])[2]")).click();
			}
		}
		Thread.sleep(2000);
		
		saveButton.click();
	}
}
