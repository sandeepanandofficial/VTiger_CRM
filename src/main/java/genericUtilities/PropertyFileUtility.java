package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of Generic or Reusable methods related to Property File
 * @author Sandeep Anand
 */

public class PropertyFileUtility {
	
	/**
	 * This method will read the data from Property File and return the String value to the caller method
	 * @param PropertyFileKey
	 * @return value
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String propertyFileKey) throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		String value = properties.getProperty(propertyFileKey);
		
		return value;
	}
	
	/**
	 * This method will help to write into property file
	 * @param key
	 * @param value
	 * @throws IOException
	 */
	public void writeDataIntoPropertyFile(String key, String value) throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		properties.setProperty(key, value);
		
		FileOutputStream fileOutputStream = new FileOutputStream(".\\src\\test\\resources\\CommonData.properties");
		
		properties.store(fileOutputStream, "Author : Sandeep Anand");
	}
}
