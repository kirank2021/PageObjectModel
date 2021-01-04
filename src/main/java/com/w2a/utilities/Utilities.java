package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.Page;

public class Utilities extends Page {
	public static String screenPath;
	public static String screenshotName;

	
	public static void CaptureScreenshot(String path) throws IOException {
		
		File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		Date d= new Date();
		screenshotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		// System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\
		try{
			FileUtils.copyFile(scrFile, new File(path+ screenshotName));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			
			table = new Hashtable<String,String>();
			for (int colNum = 0; colNum < cols; colNum++) {
				
				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;

			}
		}

		// Object[][] data = { { "kiran", "sahu", "760009" } };
		return data;
	}


}