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
public class CreateNewContactsWithCheckBoxAndBirthdayTest extends BaseClass{
	
	@Test(groups = "SmokeSuite")
	public void createNewContactWithCheckBoxAndBirthdayOnly() throws EncryptedDocumentException, IOException
	{
		//Read test data from excel file
		String LASTNAME = excelFileUtility.readDataFromExcelFileString("Contacts", 37, 3);
		String BIRTHDAY = excelFileUtility.readDataFromExcelFileDate("Contacts", 38, 3);
		Reporter.log("Test data read from excel file");
		
		//Navigate to Contact Link
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContactsLink();
		Reporter.log("Clicked on Contact Link");
		
		//Click on create contact look up image
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.clickOnCreateContactLookUpImage();
		Reporter.log("Clicked on Create Contact look up image");
		
		//Create contact with check box and birthday and save
		CreateNewContactsPage createNewContactsPage = new CreateNewContactsPage(driver);
		createNewContactsPage.createNewContactsWithCheckBoxAndBirthday(LASTNAME, BIRTHDAY);
		Reporter.log("Contact with check box and birthday created");
		
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
