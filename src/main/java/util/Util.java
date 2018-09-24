package util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import testBase.TestBase;

public class Util extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH = "C:\\seleniumProject\\ecommerce\\src\\main\\java\\testData\\Account.xlsx";

	public static Workbook book;
	public static Sheet sheet;

	// GetTestData Method will get the Data from Excel Sheet
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "--------" + sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
}
		}
		return data;
	}

	
	// ScreenShot Method
		public static void ScreenCapture() throws IOException {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/ScreenShots/" + System.currentTimeMillis() + ".png"));
			Reporter.log("<br><img src=" + currentDir + "height-'400' width-'400'/><br>");
		}

		public static void flash(WebElement element, WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			String bgcolor = element.getCssValue("backgroundColor");
			for (int i = 0; i < 10; i++) {
				changeColor("rgb(0,200,0)", element, driver);// 1
				changeColor(bgcolor, element, driver);// 2
			}
		}

		public static void changeColor(String color, WebElement element, WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
		}

		public static void drawBorder(WebElement element, WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].style.border='3px solid red'", element);
		}

		public static void generateAlert(WebDriver driver, String message) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("alert('" + message + "')");

		}

		public static void clickElementByJS(WebElement element, WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click();", element);

		}

		public static void refreshBrowserByJS(WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("history.go(0)");
		}

		public static String getTitleByJS(WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			String title = js.executeScript("return document.title;").toString();
			return title;
		}

		public static String getPageInnerText(WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			String pageText = js.executeScript("return document.documentElement.innerText;").toString();
			return pageText;
		}

		public static void scrollPageDown(WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}

		public static void scrollIntoView(WebElement element, WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	
}
