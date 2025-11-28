package com.tptrac.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {

public String getPropertyData(String key) throws IOException {
	//FileInputStream fis=new FileInputStream("./data/commondata.property");
	FileInputStream fis=new FileInputStream("./data/commondata.property");
	//C:\Users\Santosh Verma\Automation\SETAF\data
	Properties p=new Properties();
	p.load(fis);
	String data = p.getProperty(key);
	return data;
}
public String getExcelData(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./data/TestScript.xlsx"); //enabled this line and disabled next line
//	FileInputStream fis=new FileInputStream("D:\\SETAF\\src\\test\\resources\\data\\TestScript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	return data;
	}

public double getExcelNumData(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./data/TestScript.xlsx"); //enabled this line and disabled next line
//	FileInputStream fis=new FileInputStream("D:\\SETAF\\src\\test\\resources\\data\\TestScript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Double data = wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
	return data;
	}
}










