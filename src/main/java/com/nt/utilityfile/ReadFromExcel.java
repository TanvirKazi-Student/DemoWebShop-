package com.nt.utilityfile;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {

	public String readSinglDataFromExcel(String sheet, int row, int colum)
			throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(".C:\\Users\\tanvi\\OneDrive\\Desktop\\orangehrmprojectfile.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(sheet);
		return sh.getRow(row).getCell(colum).toString();
	}

	public String[][] readFromExcel(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(".C:\\Users\\tanvi\\OneDrive\\Desktop\\orangehrmprojectfile.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(sheet);
		int row = sh.getPhysicalNumberOfRows();
		int colum = sh.getRow(0).getPhysicalNumberOfCells();
		String[][] str = new String[row][colum];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < colum; j++) {
				str[i][j] = sh.getRow(i).getCell(j).toString();
			}
		}
		return str;
	}
}
