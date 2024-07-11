package contactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.HomePage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateNewContactsWithNumberFieldTest extends BaseClass{
	
	@Test(groups = "RegressionSuite")
	public void createNewContactsWithNumberFieldsOnly() throws EncryptedDocumentException, IOException
	{
		//Read test data from excel file
		String LASTNAME = excelFileUtility.readDataFromExcelFileString("Contacts", 16, 3);
		String ASSISTANTPHONE = excelFileUtility.readDataFromExcelFileLong("Contacts", 17, 3);
		String OFFICEPHONE = excelFileUtility.readDataFromExcelFileLong("Contacts", 18, 3);
		String MOBILE = excelFileUtility.readDataFromExcelFileLong("Contacts", 19, 3);
		String HOMEPHONE = excelFileUtility.readDataFromExcelFileLong("Contacts", 20, 3);
		String OTHERPHONE = excelFileUtility.readDataFromExcelFileLong("Contacts", 21, 3);
		Reporter.log("Test data read from excel file");
		
		//Navigate to Contact Link
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContactsLink();
		Reporter.log("Clicked on Contact Link");
		
		//Click on create contact look up image
		ContactsPage contactPage = new ContactsPage(driver);
		contactPage.clickOnCreateContactLookUpImage();
		Reporter.log("Clicked on Create Contact look up image");
		
		//Create contact with Number data and save
		CreateNewContactsPage createNewContactPage = new CreateNewContactsPage(driver);
		createNewContactPage.createNewContactsNumberText(LASTNAME, ASSISTANTPHONE, OFFICEPHONE, MOBILE, HOMEPHONE, OTHERPHONE);
		Reporter.log("Conatct with child window created");
		
		//Validate for the contact
		//Capture contact number
		ContactInfoPage contactInfoPage = new ContactInfoPage(driver);
		String contactHeader = contactInfoPage.captureContactHeader();
		//using assertion
		Assert.assertTrue(contactHeader.contains(LASTNAME), "Contact Header contains Last Name");
		System.out.println(contactHeader);
		Reporter.log("Contact verified");
	}
}
