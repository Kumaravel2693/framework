package org.frame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseClass1 {
	
	//data is present, we need to insert a value
	//replace old data to new data.
	
      private void updateData(String sheetname, int rowno, int cellno, String olddata, String newdata) throws IOException {

		File file=new File("C:\\Users\\Kumarkalai\\eclipse-workspace\\FrameWork\\Excel\\Demo Automation.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.createCell(cellno);
		String data = cell.getStringCellValue();
		if(data.equals(olddata)) {
			cell.setCellValue(newdata);
		}
		FileOutputStream o=new FileOutputStream(file);
		workbook.write(o);

	}
}
