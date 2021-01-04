package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\excel\\testdata.xlsx");
	public static ExtentReports extent = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	public static TopMenu menu;

	public Page() {
		if (driver == null) {
			
			PropertyConfigurator.configure("./src/test/resources/com/w2a/properties/log4j.properties");
			try {
				fis = new FileInputStream("src/test/resources/com/w2a/properties/Config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			log.debug("config file loaded");

			try {
				fis = new FileInputStream("src/test/resources/com/w2a/properties/OR.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			log.debug("OR property  file loaded");

		
		// Jenkins Browser filter configuration
		if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

			browser = System.getenv("browser");
		} else {

			browser = config.getProperty("browser");

		}

		config.setProperty("browser", browser);

		if (config.getProperty("browser").equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
				/*
				 * Map<String, Object> prefs = new HashMap<String, Object>();
				 * prefs.put("profile.default_content_setting_values.notifications", 2);
				 * prefs.put("credentials_enable_service", false);
				 * prefs.put("profile.password_manager_enabled", false); ChromeOptions options =
				 * new ChromeOptions(); options.setExperimentalOption("prefs", prefs);
				 * options.addArguments("--disable-extensions");
				 * options.addArguments("--disable-infobars");
				 */
			driver = new ChromeDriver();
			log.debug("chrome loaded");

		}

		else if (config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (config.getProperty("browser").equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}

		driver.get(config.getProperty("testURL"));
		log.debug("URL is loaded");

		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

		menu = new TopMenu(driver);
	}
	}
	public static void click(String locator) {
		//driver.findElement(By.xpath(OR.getProperty(locator))).click();
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
		 
		//test.log(Status.INFO, "clicking on"+locator);
		testReport.get().log(Status.INFO, "clicking on the  : " + locator );

	}
	public static void quit() {
		//driver.quit();
		//l
	}
	public static void type(String locator,String value ) {
		//driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
		 
		testReport.get().log(Status.INFO, "Sending keys on the  : " + locator );



		
	}
	public static WebElement dropdown;
	public void select(String locator,String value) {
		dropdown=driver.findElement(By.cssSelector(OR.getProperty(locator)));

		Select select= new Select(dropdown);
		select.selectByVisibleText(value);
		System.out.println(locator);
		System.out.println(value);

		testReport.get().log(Status.INFO, "Selecting from dropdown : " + locator + " value as " + value);
	}
	
public boolean isTestRunnable(String TestName,ExcelReader excel) {
		
		int row=excel.getRowCount("test_suite");
		
		for(int rNum=2; rNum<=row; rNum++) {
			
			String testCase=excel.getCellData("test_suite", "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(TestName)) {
				
				String runMode=excel.getCellData("test_suite", "Runmode", rNum);
				
				if(runMode.equalsIgnoreCase("Y")) {
					return true;
				}else {
					return false;
				}
				
			}
		}
		return false;
		
	}
	
	public static void verifyEquals(String actual,String expected) throws IOException {
		try {
			Assert.assertEquals(actual, expected);
		}catch(Throwable t) {
			  
			  
				  //  C:\Users\LENOVO\eclipse-workspace\DataDrivenFramework\test-output\html
			Utilities.CaptureScreenshot(System.getProperty("user.dir")+"\\PageObjectModelBasics"
				  		+ "\\test-output\\html\\"); 
			  
			 Reporter.log("<br>"+"Verification failure"+t.getMessage()+"<br>");
			 Reporter.log("<br>");

		  
			 Reporter.log("Click to see failed assert screenshot");
			 Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+ ">Error assert screenshot</a>"); 
			 //////Extent Report///
			 try {
				 testReport.get().fail("<b>"+"Verification failed"+t.getMessage()+"<b>");
				 Utilities.CaptureScreenshot(System.getProperty("user.dir")+"PageObjectModelBasics\\target\\surefire-reports\\html\\");
				 testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failed assert" + "</font>" + "</b>",
						MediaEntityBuilder.createScreenCaptureFromPath(Utilities.screenshotName).build());
			} catch (IOException e) {
				 e.printStackTrace();
			}
			  
		}
		
	}


}

