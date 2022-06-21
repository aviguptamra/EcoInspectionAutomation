package com.ECO.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.ECO.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestUtil extends TestBase implements ITestListener, IRetryAnalyzer {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH = "/home/mayankgupta/Desktop/ECOInspectionTest/src/main/java/com/ECO/qa/testdata/Eco_data.xlsx";
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	private int retryCounter = 0;
	private int maxRetry = 2;
	public TestUtil(){super();}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
			System.out.println(book.getSheetIndex("Repair"));
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}




	@Override
	public void onTestStart(ITestResult iTestResult) {

	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {

	}

	@Override
	public void onTestFailure(ITestResult result) {

		try {
			screenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	@Override
	public void onStart(ITestContext iTestContext) {

	}

	@Override
	public void onFinish(ITestContext iTestContext) {

	}


	public void screenshot(String SS) throws IOException {
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("/home/mayankgupta/Desktop/ECOInspectionTest/screenshots/"+SS+".png"));
	}

	@Override
	public boolean retry(ITestResult iTestResult) {
		if (retryCounter < maxRetry) {
			retryCounter++;
			return true;
		}
		return false;
	}
}
