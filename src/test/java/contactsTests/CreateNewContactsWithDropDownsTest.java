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
public class CreateNewContactsWithDropDownsTest extends BaseClass{
	
	@Test(groups = "RegressionSuite")
	public void createNewContactWithDropDownsOnly() throws EncryptedDocumentException, IOException
	{
		//Read test data from excel file
		String PREFIX = excelFileUtility.readDataFromExcelFileString("Contacts", 31, 3);
		String LASTNAME = excelFileUtility.readDataFromExcelFileString("Contacts", 32, 3);
		String LEADSOURCE = excelFileUtility.readDataFromExcelFileString("Contacts", 33, 3);
		Reporter.log("Test data read from excel file");
		
		//Navigate to Contact Link
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContactsLink();
		Reporter.log("Clicked on Contact Link");
		
		//Click on create contact look up image
		ContactsPage contactPage = new ContactsPage(driver);
		contactPage.clickOnCreateContactLookUpImage();
		Reporter.log("Clicked on Create Contact look up image");
		
		//Create contact with drop down and save
		CreateNewContactsPage createNewContactsPage = new CreateNewContactsPage(driver);
		createNewContactsPage.createNewContactsWithDropDown(LASTNAME, LEADSOURCE, PREFIX);
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
