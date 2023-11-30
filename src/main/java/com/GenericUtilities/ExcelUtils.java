package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * This file contains method for reading data from ExcelFile
 * value and sheetName are dynamic
 * 
 * 
 */
public class ExcelUtils {

	/**This method reads data from excel file
	 * 
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws IOException
	 */
 
	public String readFromExcelFile(String SheetName,int row ,int cell) throws IOException 
	{
		FileInputStream fis=new FileInputStream(IPathConstants1.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet ss = wb.getSheet(SheetName);
		ss.getRow(row);
		String value = ss.getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}
	/**
	 * 
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public void writeDataToExcelFile(String sheetName,int row,int cell,String keyvalue,String cellvalue)  throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis= new FileInputStream(IPathConstants1.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet ss = wb.getSheet(sheetName);
		ss.createRow(row).createCell(cell).setCellValue(keyvalue);
		ss.getRow(row).createCell(cell).setCellValue(cellvalue);
		FileOutputStream fos=new FileOutputStream(IPathConstants1.ExcelPath);
		wb.write(fos);
		wb.close();
		
		
	}
/**this method is used to get total row count
 * 
 * @param sheetName
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public int getLastRowNum(String sheetName) throws EncryptedDocumentException, IOException
{
	FileInputStream fis= new FileInputStream(IPathConstants1.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	
	Sheet ss = wb.getSheet(sheetName);
	int count = ss.getLastRowNum();
	
	return count;
	
}
/**This method reads multiple data from excel file
 * 
 * @param sheetName
 * @param driver
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public void readMultipleData(String sheetName,WebDriver driver,int KeyCell,int ValueCell)throws EncryptedDocumentException, IOException
{
	ExcelUtils e=new ExcelUtils();
	JavaUtils j=new JavaUtils(); 
	FileInputStream fis= new FileInputStream(IPathConstants1.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	
	Sheet ss = wb.getSheet(sheetName);
	int count=e.getLastRowNum(sheetName);

	HashMap<String ,String>hs=new HashMap<String, String>();
	
	for(int i=0;i<=count;i++)
	{
		String key=ss.getRow(i).getCell(KeyCell).getStringCellValue();
		String value=ss.getRow(i).getCell(ValueCell).getStringCellValue();
		hs.put(key, value);
	}
	for(Entry<String, String> map:hs.entrySet())
	{
		driver.findElement(By.name(map.getKey())).sendKeys(map.getValue()+j.randomNum());
	}
}



public Object[][] getMultiplesetOfData(String sheetName) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream(IPathConstants1.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet ss = wb.getSheet(sheetName);
	int rowcount = ss.getPhysicalNumberOfRows();
	int cellcount=ss.getRow(0).getLastCellNum();
	
	Object [][]obj=new Object[rowcount][cellcount];
	
	for (int i=0;i<rowcount;i++)
	{
		for(int j=0;j<cellcount;j++)
		{
			obj[i][j]=ss.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}