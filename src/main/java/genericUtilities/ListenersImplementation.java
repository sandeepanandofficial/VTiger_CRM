package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class will provide implementation to ITestListener interface
 * @author Sandeep Anand
 */
public class ListenersImplementation implements ITestListener{
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestStart(result);
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ********** Test script execution started ********** ");
		
		//create a test for @Test in extent report
		extentTest = extentReport.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSuccess(result);
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(" ********** TEST IS PASS ********** ");
		
		//Log the PASS status in extent reports
		extentTest.log(Status.PASS, methodName + " ********** TEST IS PASS ********** ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailure(result);
		
		SeleniumWebDriverUtility seleniumWebDriverUtility = new SeleniumWebDriverUtility();
		JavaUtility javaUtility = new JavaUtility();
		
		String methodName = result.getMethod().getMethodName();
		String screenshotName = methodName + javaUtility.getSystemDateAndTime();
		
		System.out.println(methodName + " ********** TEST IS FAIL ********** ");
		System.out.println(result.getThrowable());	//reason of failure
		
		//Log the FAIL status in extent reports
		extentTest.log(Status.FAIL, methodName + " ********** TEST IS FAIL ********** ");
		//Log the INFO status in extent reports
		extentTest.log(Status.INFO, result.getThrowable());	//reason of failure
		
		try {
			String path = seleniumWebDriverUtility.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			//attach the screenshot into the extent report
			extentTest.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSkipped(result);
		
		System.out.println(result.getThrowable());
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(" ********** TEST IS SKIP ********** ");
		System.out.println(result.getThrowable());	//reason of skip
		
		//Log the SKIP status in extent reports
		extentTest.log(Status.SKIP, methodName + " ********** TEST IS SKIP ********** ");
		//Log the INFO status in extent reports
		extentTest.log(Status.INFO, result.getThrowable());	//reason of skip
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onStart(context);
		
		System.out.println(" ********** Suite execution started ********** ");
		
		//Configure the extent Reports
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(".\\ExtentReports\\Report-" + new JavaUtility().getSystemDateAndTime() + ".html");
		extentSparkReporter.config().setDocumentTitle("Vtiger Execution Report");
		extentSparkReporter.config().setReportName("Automation Execution Report");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentSparkReporter);
		extentReport.setSystemInfo("Base Platform", "Windows");
		extentReport.setSystemInfo("Base Browser", "Chrome");
		extentReport.setSystemInfo("Base URL", "https://localhost:8888");
		extentReport.setSystemInfo("Base Environment", "Sandeep Anand");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context);
		
		System.out.println(" ********** Suite execution finished ********** ");
		
		//generate the report after execution
		extentReport.flush();	//Execution complete
	}
	
	
}
