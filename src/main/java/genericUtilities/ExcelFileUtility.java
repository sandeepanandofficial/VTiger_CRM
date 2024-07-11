package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic or reusable method related to Excel file
 * @author Sandeep Anand
 */

public class ExcelFileUtility {
	
	/**
	 * This method will read the String data from excel file and return value to the caller method
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return valueString
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcelFileString(String sheetName, int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(".\\src\\test\\resources\\VTiger Test Data.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.getCell(cellNumber);
		
		String valueString = cell.getStringCellValue();
		
		workbook.close();
		
		return valueString;
	}
	
	/**
	 * This method will read the Long data from excel file and return value to the caller method
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return valueLong
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcelFileLong(String sheetName, int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(".\\src\\test\\resources\\VTiger Test Data.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.getCell(cellNumber);
		
		double valueDouble = cell.getNumericCellValue();
		
		long valueLong = (long)valueDouble;
		
		String valueString = String.valueOf(valueLong);
		
		workbook.close();
		
		return valueString;
	}
	
	/**
	 * This method will read the date data from excel file and return value to the caller method
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return valueString
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFileDate(String sheetName, int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(".\\src\\test\\resources\\VTiger Test Data.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.getCell(cellNumber);
		
		Date valueDate = cell.getDateCellValue();
		
		String dateFormat = "YYYY-MM-DD";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		
		String valueDateFormat = simpleDateFormat.format(valueDate);
		
		String valueString = valueDateFormat.toString();
		
		workbook.close();
		
		return valueString;
	}
	
	/**
	 * This method will read the multiple data from excel file and return value to the caller method
	 * @param sheetName
	 * @return valueObject
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcelFile(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(".\\src\\test\\resources\\VTiger Test Data.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] valueObject = new Object[lastRow][lastCell];
		
		for(int i=0 ; i<lastRow ; i++)
		{
			for(int j=0 ; j<lastCell ; j++)
			{
				valueObject[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return valueObject;
	}
	
	/**
	 * This method will write data into excel sheet
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcelFile(String sheetName, int rowNumber, int cellNumber, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(".\\src\\test\\resources\\VTiger Test Data.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.createSheet(sheetName);
		Row row = sheet.createRow(rowNumber);
		Cell cell = row.createCell(cellNumber);
		
		cell.setCellValue(value);
		
		FileOutputStream fileOutputStream = new FileOutputStream(".\\src\\test\\resources\\VTiger Test Data.xlsx");
		workbook.write(fileOutputStream);
		workbook.close();
	}
}
