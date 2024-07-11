package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for IRetryAnalyzer interface of TestNG
 * @author Sandeep Anand
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer{
	
	int count = 0;
	int retryCount = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		while(count < retryCount)
		{
			count++;
			return true;
		}
		return false;
	}
	
	
}
