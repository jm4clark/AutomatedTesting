package com.bae.apache.test;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bae.apache.resources.Constant;

public class Tests {
	public static WebDriver driver;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	@BeforeClass
	public static void setup() {
		System.setProperty(Constant.CHROMEWD[0], Constant.CHROMEWD[1]);
		driver = new ChromeDriver();

		FileInputStream file = null;
		try {
			file = new FileInputStream(Constant.DATA1);
		} catch (FileNotFoundException e) {
		}

		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
		}

		sheet = workbook.getSheetAt(0);
	}

	@Test
	public void testLogins() {

		driver.manage().window().maximize();
		driver.get(Constant.URL1);

		for (int i = 1; i < 5; i++) {
			driver.navigate().to(Constant.URL1);

			XSSFCell username = sheet.getRow(i).getCell(0);
			XSSFCell password = sheet.getRow(i).getCell(1);

			driver.findElement(By.name("username")).sendKeys(username.getStringCellValue());

			driver.findElement(By.name("password")).sendKeys(password.getStringCellValue());

			driver.findElement(By.name("FormsButton2")).click();

			driver.navigate().to(Constant.URL2);

			driver.findElement(By.name("username")).sendKeys(username.getStringCellValue());

			driver.findElement(By.name("password")).sendKeys(password.getStringCellValue());

			driver.findElement(By.name("FormsButton2")).click();

			String result = driver
					.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"))
					.getText();
			System.out.println(result);
			
			XSSFCell resultCell = sheet.getRow(i).getCell(2); 
			
			System.out.println("Cell value: " + resultCell.getRawValue());
			
			if(resultCell.equals(null)) {
				sheet.getRow(i).createCell(2);
			}
			
			CellStyle style = workbook.createCellStyle();
			if (result.contains("Success")) {
				style.setFillForegroundColor(IndexedColors.GREEN.getIndex());

				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				resultCell.setCellStyle(style);
			} else {
				style.setFillForegroundColor(IndexedColors.RED.getIndex());

				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				resultCell.setCellStyle(style);
			}

			resultCell.setCellValue(result);

			
			try {
				FileOutputStream out = new FileOutputStream(new File(Constant.DATA1));

				workbook.write(out);
				System.out.println("File saved");
				

			} catch (IOException e) {
				System.out.println("File not saved");
			}
		}
	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}
}
