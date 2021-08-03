package com.test;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pages.LoginPage;

public class TestBase {

	public static  WebDriver driver = null;	
	 public ExtentHtmlReporter htmlReporter;
	 public ExtentReports extent;
	 public static ExtentTest logger;	
	 public static ExtentTest extTest;
	 //public static ExtendTest extTest1;
	static Properties prop = null;
	static FileInputStream fis = null;
	LoginPage lp = null;
	public static Logger logs=null;
	
	@BeforeSuite
	public void startReport() {
		 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
		 
		 htmlReporter.config().setDocumentTitle("Automation Report"); //title of report
		 htmlReporter.config().setReportName("Funtional Report"); //Name of the report
		 htmlReporter.config().setTheme(Theme.STANDARD); 
		 extent = new ExtentReports();  
		 
		 extent.attachReporter(htmlReporter);
		 
		 extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		 extent.setSystemInfo("Environment", "Production");
		 extent.setSystemInfo("User Name", "Surbhi K");
		 		
		 }
	
	
	 //This method is to capture the screenshot and return the path of the screenshot.
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/ScrrenshotER/Screenshots/" + screenshotName + dateName + ".jpg";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	

	 @AfterMethod
	 public void getResult(ITestResult result) throws Exception{
	 if(result.getStatus() == ITestResult.FAILURE){
	
	 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	// logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));	 
	 String screenshotPath = getScreenShot(driver, result.getName());	 
	// logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
	 }
	 else if(result.getStatus() == ITestResult.SKIP){
	 logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
	 } 
	 else if(result.getStatus() == ITestResult.SUCCESS)
	 {
	 logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	 }
	 driver.quit();
	 }
	 
	
	 @AfterSuite
	 public void endReport() {
	 extent.flush();
	 }
	 
	 @BeforeTest
	 public void BeforeTest1() {
		 extTest = extent.createTest("All Pages","TestCases of All Pages");
		// extTest=extent.createTest(getClass().getName());
		 
	 }
	
	static String readAnyProperty (String propName) throws IOException {
		String val = null;
		
		try {
			fis= new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources/" + "/Config.properties");
			prop = new Properties();
			prop.load(fis);
			val = prop.getProperty(propName);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		return val;
	}
	
	public static WebDriver OpenBrower() throws Throwable {
		String URL = readAnyProperty("url");
		String browser = readAnyProperty("browser");
		
		System.setProperty("webdriver.chrome.driver", "D/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(URL);
		
		return driver;
	}
	
	public LoginPage loadLoginPage() {
		LoginPage lp = new LoginPage(driver);
		 return lp;
		
	}
	
	public Logger testLogs() {
		logs = Logger.getLogger(this.getClass());
		String path = (System.getProperty("user.dir")+ "/src/test/resources/" + "/log4jTest.properties");
		PropertyConfigurator.configure(path);
		return logs;
	}
	
}
