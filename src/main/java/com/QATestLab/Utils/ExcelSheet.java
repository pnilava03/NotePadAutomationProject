package com.QATestLab.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
		
	private FileInputStream fis;
	private Workbook workbook;
	private Sheet sheet_Name;
	private Properties prop= new Properties();
	{
		try {
			prop.load(new FileInputStream(new File("./resources/config/test.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ExcelSheet(String excelSheetPath) {
		try {
			fis= new FileInputStream(new File(prop.getProperty(excelSheetPath)));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public String getDataFromExcelSheet(String sheetName,int rowNum,int cellNum) {
		try {
			try {
				workbook=WorkbookFactory.create(fis);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			}
		} catch (EncryptedDocumentException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 sheet_Name=workbook.getSheet(sheetName);
		 
		Row row=sheet_Name.getRow(rowNum);
		String value=row.getCell(cellNum).getStringCellValue();
		
		return value;
		
	}

}
