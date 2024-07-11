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

//@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateNewContactsWithBirthday extends BaseClass{
	
	//@Test
	public void createNewContactWithBirthdayOnly() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Read test data from excel file
		String LASTNAME = excelFileUtility.readDataFromExcelFileString("Contacts", 1, 3);
//		Reporter.log("Data read from Excel file");
		
		//Navigate to Contact Link
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContactsLink();
//		Reporter.log("Click on Contact Link");
		
		//CLick on create contact look up image
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.clickOnCreateContactLookUpImage();
//		Reporter.log("Click on Contact look up image");
		
		//Create contact with Birthday and save
		CreateNewContactsPage createNewContactsPage = new CreateNewContactsPage(driver);
		createNewContactsPage.createNewContactsWithBirthday(LASTNAME, driver);
//		Reporter.log("Contact with Birthday created");
		
		//Validate for the Contact
		//Capture contact header
		ContactInfoPage contactInfoPage = new ContactInfoPage(driver);
		String contactHeader = contactInfoPage.captureContactHeader();
		//using assertion
		Assert.assertTrue(contactHeader.contains(LASTNAME), "Contact Header contains Last Name");
		System.out.println(contactHeader);
//		Reporter.log("Contact Verified");
	}
}
