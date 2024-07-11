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
public class CreateNewContactsWithStringsFieldTest extends BaseClass{
	
	@Test(groups = "RegressionSuite")
	public void createNewContactsWithStringsFieldsOnly() throws EncryptedDocumentException, IOException
	{
		//Read data from Excel file
		String FIRSTNAME = excelFileUtility.readDataFromExcelFileString("Contacts", 5, 3);
		String LASTNAME = excelFileUtility.readDataFromExcelFileString("Contacts", 6, 3);
		String TITLE = excelFileUtility.readDataFromExcelFileString("Contacts", 7, 3);
		String DEPARTMENET = excelFileUtility.readDataFromExcelFileString("Contacts", 8, 3);
		String EMAIL = excelFileUtility.readDataFromExcelFileString("Contacts", 9, 3);
		String ASSISTANT = excelFileUtility.readDataFromExcelFileString("Contacts", 10, 3);
		String FAX = excelFileUtility.readDataFromExcelFileString("Contacts", 11, 3);
		String SECONDARYEMAIL = excelFileUtility.readDataFromExcelFileString("Contacts", 12, 3);
		Reporter.log("Test data read from excel file");
		
		//Navigate to contacts link
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContactsLink();
		Reporter.log("Clicked on Contact Link");
		
		//Click on create contact look up image
		ContactsPage contactPage = new ContactsPage(driver);
		contactPage.clickOnCreateContactLookUpImage();
		Reporter.log("Clicked on Create Contact look up image");
		
		//Create contact with String data and save
		CreateNewContactsPage createNewContactsPage = new CreateNewContactsPage(driver);
		createNewContactsPage.createNewContactsWithStringText(FIRSTNAME, LASTNAME, TITLE, DEPARTMENET, EMAIL, ASSISTANT, FAX, SECONDARYEMAIL);
		Reporter.log("Conatct with child window created");
		
		//Validate for the Contact
		//Capture contact header
		ContactInfoPage contactInfoPage = new ContactInfoPage(driver);
		String contactHeader = contactInfoPage.captureContactHeader();
		//using assertion
		Assert.assertTrue(contactHeader.contains(LASTNAME), "Contact Header contains Last Name");
		System.out.println(contactHeader);
		Reporter.log("Contact verified");
	}
}
