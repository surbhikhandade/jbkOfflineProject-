package com.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pages.DashboardPage;
import com.pages.LoginPage;

public class LoginPageTest extends TestBase {
		
	public WebDriver driver = null;
	public LoginPage lp=null;	
	public ExtentTest extPages=null;
	
		  @BeforeMethod
			public void Setup() throws Throwable {
				
			   driver=TestBase.OpenBrower();		   
				lp = new LoginPage(driver);
			}
		  
		  
		  
		  @BeforeClass
		  public void beforeTest() {
			  extPages =extTest.createNode("Login TestCases");
		  }
	
		  @Test(priority=1)
		  public void verifyTitle() {
			 ExtentTest extTest1= extPages.createNode("Test Case 1 : verifyTitle");
			  testLogs().info("verify Title of LoginPage");
			  extTest1.info("To verify Title of LoginPage");
			  logger=extent.createTest("verify");
			  Assert.assertTrue(lp.verifyLoginPage_title(extTest1));
		  }
		  
		  @Test(priority=2)
		  public void verify_Logo() {
			  ExtentTest extTest1= extPages.createNode("Test Case 2 : verify Logo");
			  testLogs().info("verify Logo of LoginPage");
			  extTest1.info("To verify Logo");
			  Assert.assertTrue(lp.verifyJbk_Logo(extTest1));
		  }
		  
		  @Test(priority=3)
		  public void verify_LoginText1() {
			  ExtentTest extTest1= extPages.createNode("Test Case 3 : verify Heading");
			  testLogs().info("verify Text on LoginPage");
			  extTest1.info("To verify LoginPage Text");
			  Assert.assertTrue(lp.verifyText_loginPage1(extTest1));
		  }
		  
		  @Test(priority=4)
		  public void verify_LoginText2() {
			  ExtentTest extTest1= extPages.createNode("Test Case 4 : verify Heading2");
			  testLogs().info("verify text on LoginPage");
			  extTest1.info("To verify LoginPage Text");
			 		  
			  Assert.assertTrue(lp.verifyText_loginPage2(extTest1));
		  }
		  
		  @Test(priority=5)
		  public void verify_LoginText3() {
			  ExtentTest extTest1= extPages.createNode("Test Case 5 : verify Heading3");
			  testLogs().info("verify text on LoginPage");
			  extTest1.info("To verify LoginPage Text");
			  Assert.assertTrue(lp.verifyText_loginPage3(extTest1));
		  }
		  
		  @Test(priority=6)
		  public void verify_Without_Fill_EmailPass() {
			  
			  testLogs().info("verify Without Fill Email and Password on LoginPage Error show");
			  logger = extent.createTest("To verify Without Fill Email and Password on LoginPage Error show");
			  Assert.assertTrue(lp.verifyBlank_emailpass());
		  }
		  
		  @Test(priority=7)
		  public void verify_Password_Error() {
			  testLogs().info("verify Without Fill Password on LoginPage Error show");
			  logger = extent.createTest("To verify Without Fill Password on LoginPage Error show");
			  Assert.assertTrue(lp.verifyPassword());
		  }
		  
		  @Test(priority = 8)
		  public void verify_Email_Error() {
			  testLogs().info("verify Without Fill Email  on LoginPage Error show");
			  logger = extent.createTest("To verify Without Fill Email  on LoginPage Error show");
			  Assert.assertTrue(lp.verifyEmail());
		  }
		  
		  @Test(priority = 9)
		  public void verify_InvalidPassword() {
			  testLogs().info("verify Invalid  Password on LoginPage Error show");
			  logger = extent.createTest("To verify Invalid  Password on LoginPage Error show");
			  Assert.assertTrue(lp.verifyInvalid_password());
		  }
		  
		  @Test(priority = 10)
		  public void verify_InvalidEmail() {
			  testLogs().info("verify Invalid  Email on LoginPage Error show");
			  logger = extent.createTest("To verify Invalid  Email on LoginPage Error show");
			  Assert.assertTrue(lp.verifyInvalid_email());
		  }
		  
		 @Test(priority = 11)
			public void verify_DashboardTitle() {
			  testLogs().info("verify Valid Email & Password fill and Dashboard Page Open");
			  logger = extent.createTest("To verify  Valid Email & Password fill and Dashboard Page Open");
			  Assert.assertTrue(lp.verifyLogin());
		  }
		 
		
		 
		 
}
