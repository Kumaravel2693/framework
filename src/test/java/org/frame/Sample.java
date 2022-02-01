package org.frame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		WebElement elementSkills = driver.findElement(By.id("Skills"));
		Select se=new Select(elementSkills);
		List<WebElement> options = se.getOptions();
		int size = options.size();
		System.out.println(size);
		File file=new File("C:\\Users\\Kumarkalai\\eclipse-workspace\\FrameWork\\Excel\\kumar.xlsx");

	    Workbook workbook = new XSSFWorkbook();
	       
	       Sheet sheet = workbook.createSheet("kumar");
	       
		   for (int i = 0; i < size; i++) {
			   Row row = sheet.createRow(i);
			   Cell createCell = row.createCell(0);
			   WebElement element = options.get(i);
			   String text = element.getText();
               createCell.setCellValue(text);			
		   }
		   FileOutputStream o=new FileOutputStream(file);
		   workbook.write(o);
			
		}
	}


