package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic generic or reusable methods related to java
 * @author Sandeep Anand
 */

public class JavaUtility {
	
	/**
	 * This method will capture the current system date and return current system date
	 * @return systemDate
	 */
	
	public String getSystemDateAndTime()
	{
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
		String systemDate = simpleDateFormat.format(date);
		
		return systemDate;
	}
	
	/**
	 * This method will return a random number for every execution
	 * @return randomNumber
	 */
	public int getRandomNumber()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(1000);
		
		return randomNumber;
	}
}
