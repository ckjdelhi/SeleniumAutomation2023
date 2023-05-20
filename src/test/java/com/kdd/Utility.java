package com.kdd;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility {
	private WebDriver driver=null;
	public Utility() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	public void openBrowser() {
		driver.get("https://demo.guru99.com/v4/");
	}
	public void fillTextBox(String locator, String locatorValue, String parameter) {
		By loc = getLocatorBy(locator, locatorValue);
		if(loc !=null) {
			driver.findElement(loc).sendKeys(parameter);
		}
	}
	public void clickButton(String locator, String locatorValue) {
		By by = getLocatorBy(locator, locatorValue);
		driver.findElement(by).click();
	}
	
	private By getLocatorBy(String locator, String locatorValue) {
		By loc=null;
		if(locator.equals("name")) {
			loc=By.name(locatorValue);
		}else if(locator.equals("xpath")) {
			loc=By.xpath(locatorValue);
		}else if(locator.equals("id")) {
			loc=By.id(locatorValue);
		}else if(locator.equals("cssSelector")) {
			loc=By.cssSelector(locatorValue);
		}
		return loc;
	}

	
	public String[][] fetchDataFromExcel() throws Exception {
		//XSSF - .xlsx
		//HSSF - .xls
		String path = "C:\\Users\\chand\\Desktop\\book1.xlsx";
		FileInputStream fs=new FileInputStream(new File(path));
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rows = sheet.getLastRowNum();
		int colums = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rows+1][colums];
		for(int i=0;i<=rows; i++) {
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<colums;j++) {
				XSSFCell cell=row.getCell(j);
				if(cell !=null) {
					String value = cell.toString();
					data[i][j] = value;
				}
			}
		}
		workbook.close();
		return data;
		
	}

}
