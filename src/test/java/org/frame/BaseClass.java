package org.frame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseClass {
	
	//write a code to insert value in cell
	//row created, but cell is emplty.
	//create a cell and insert value

	private void writeData(String SheetName, int rowno, int CellNo, String Data) throws IOException {
		
		File file=new File("C:\\Users\\Kumarkalai\\eclipse-workspace\\FrameWork\\Excel\\Demo Automation.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowno);
		Cell cell = row.createCell(CellNo);
		cell.setCellValue(Data);
		FileOutputStream o=new FileOutputStream(file);
		workbook.write(o);

	}
}
