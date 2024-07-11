package genericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of generic or reusable methods related to all basic configuration and annotation of testNG
 * @author Sandeep Anand
 */
public class BaseClass {
	
	public DatabaseUtility dataBaseUtility = new DatabaseUtility();
	public PropertyFileUtility propertyFileUtility = new PropertyFileUtility();
	public ExcelFileUtility excelFileUtility = new ExcelFileUtility();
	public JavaUtility javaUtility = new JavaUtility();
	public SeleniumWebDriverUtility seleniumWebDriverUtility = new SeleniumWebDriverUtility();
	
	public WebDriver driver;
	
	public static WebDriver sdriver;	// ---> For Listeners
	
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuiteConfiguration() throws IOException, SQLException
	{
		String dataBaseUrl = propertyFileUtility.readDataFromPropertyFile("databaseURL");
		String dataBaseUserName = propertyFileUtility.readDataFromPropertyFile("databaseUSERNAME");
		String dataBasePassword = propertyFileUtility.readDataFromPropertyFile("databasePASSWORD");
		
		dataBaseUtility.connectToDatabase(dataBaseUrl, dataBaseUserName, dataBasePassword);
		
		System.out.println(" ********** Database connection established **********");
	}
	
//	@Parameters("browser")	// ---> for cross browser
//	@BeforeTest(alwaysRun = true)
	@BeforeClass(alwaysRun = true)
	public void beforeClassConfiguration(/*String BROWSER*/) throws IOException
	{
		String BROWSER = propertyFileUtility.readDataFromPropertyFile("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Browser not supported");
		}
		
		String URL = propertyFileUtility.readDataFromPropertyFile("url");
		
		seleniumWebDriverUtility.maximizeWindow(driver);
		seleniumWebDriverUtility.implicitlyWaitForPageLoad(driver);
		
		driver.get(URL);
		
		sdriver = driver;	// ---> For Listeners
		
		System.out.println(" ********** Browser is Launched **********");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethodConfiguration() throws IOException
	{
		String USERNAME = propertyFileUtility.readDataFromPropertyFile("username");
		String PASSWORD = propertyFileUtility.readDataFromPropertyFile("password");
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.LoginToApplication(USERNAME, PASSWORD);
		
		System.out.println(" ********** Login is Successful ********** ");
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethodConfiguration() throws InterruptedException
	{
		HomePage homePage = new HomePage(driver);
		
		homePage.signOutFromApplication(driver);
		
		System.out.println(" ********** SignOut is Successful ********** ");
	}
	
//	@AfterTest(alwaysRun = true)
	@AfterClass(alwaysRun = true)
	public void afterClassConfiguration()
	{
		driver.quit();
		
		System.out.println(" ********** Browser is Closed ********** ");
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuiteConfiguration() throws SQLException
	{
		dataBaseUtility.closeTheConnectionAndStatement();
		
		System.out.println(" ********** Database connection closed ********** ");
	}
}
