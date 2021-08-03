package com.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.UserPage;

import jxl.Workbook;
import jxl.read.biff.BiffException;

public class UserPageTest extends TestBase{
	
	public WebDriver driver=null;
	
	public UserPage up = null;
	
	@BeforeMethod
	public void Setup() throws Throwable  {
		/*System.setProperty("webdriver.chrome.driver", "D/chromedriver.exe");
		System.out.println("Open Chrome Driver");
		driver = new ChromeDriver();*/
		driver= OpenBrower();
		up=loadLoginPage().navigateToDashboardPage(driver).navigatetToUserPage(driver);
		up= new UserPage(driver);
		
		driver.manage().window().maximize();
		
		System.out.println("Open JBK Website");
	}
	
	  @Test(priority=1)
	  public void verifyUserPageTitle() {
		  testLogs().info("verify Title of UserPage");
		  logger = extent.createTest("To verify User Title");
		  Assert.assertTrue(up.verifyUserPage_Title());
	  }
	  
	  @Test(priority=2)
	  public void verifyHeaderText() {
		  testLogs().info("verify Header Text of UserPage");
		  logger = extent.createTest("To verify User Text");
		  Assert.assertTrue(up.verifyHeader_Text());
	  }
	  
	  @Test(priority=3)
	  public void verifyHeaderCheckWithExcel() throws Exception {
		  try {
			  testLogs().info("verify Check header of UserPage table");
			  logger = extent.createTest("To verify header of userpage");
			Assert.assertTrue(up.verifyHeaders_Spelling());
		} catch (BiffException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	    
	 
	  @Test(priority=4)
	  public void verifygmail() {
		  testLogs().info("verify End Of gmail");
		  logger = extent.createTest("To verify End Of gmail");
		  Assert.assertTrue(up.verifygmailcom());
	  }
	  
	  @Test(priority=5)
	  public void verifyEndWith_ale() {
		  testLogs().info("verify End Of ale");
		  logger = extent.createTest("To verify End Of ale");
		  Assert.assertTrue(up.verifygender());
	  }
	  
	  @Test(priority=5)
	  public void verifylengthmobile() {
		  testLogs().info("verify Mobile no length");
		  logger = extent.createTest("To verify MobileNo Length ");
		  SoftAssert sa = new SoftAssert();
			for(boolean b :up.mobileLength()) {
				sa.assertTrue(b);
			}
			sa.assertAll();
	  
	  }
	  
	  @Test(priority=6)
	  public void verifyMaleFemale() {
		  testLogs().info("verify Male and Female in UserPage");
		  logger = extent.createTest("To verify Male and Female in UserPage");
		  Assert.assertTrue(up.verifyMale_Female());
	  }
	  
	  @Test(priority=7)
	  public void verifyusername_count() {
		  testLogs().info("verify Male and Female in UserPage");
		  logger = extent.createTest("To verify Male and Female in UserPage");
		  Assert.assertTrue(up.verifyCount_of_username());
	  }
	  
	  @Test(priority=8)
	  public void verifyUsername_Sort() {
		  testLogs().info("verify Sorting of Username");
		  logger = extent.createTest("To verify Username Sorted");
		  Assert.assertTrue(up.verifysort_of_username());
	  }
	  
	  @Test(priority=9)
	  public void verifyAddUserButton_Enabled() {
		  testLogs().info("verify AddUser Button is enabled or not On UserPage");
		  logger = extent.createTest("To verify AddUser Button is enabled or not On UserPage");
		  Assert.assertTrue(up.verifyAddUser_IsEnabled());
	  }
	  
	  @Test(priority=10)
	  public void verifyDeleteBtnEnabled() {
		  testLogs().info("verify Delete Button is enabled or not On UserPage");
		  logger = extent.createTest("To verify Delete Button is enabled or not On UserPage");
		  Assert.assertTrue(up.verifyDeleteButton_IsEnabled());
	  }
	  
	  @Test(priority=11)
	  public void verifyDeleteAlert_Second() {
		  try {
			  testLogs().info("verify Second Delete Button Popup handled On UserPage");
			  logger = extent.createTest("To verify Second Delete Button Popup handled On UserPage");
			Assert.assertTrue(up.verifyDeleteBtnPopup());
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	  
	  
	  @Test(priority=12)
	  public void verifyDeleteAlert_First() {
		  try {
			  testLogs().info("verify First Delete Button Popup handled On UserPage");
			  logger = extent.createTest("To verify First Delete Button Popup handled On UserPage");
			Assert.assertTrue(up.verifyFirstDeleteBtnPopup());
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	  
	  
	  @Test(priority=13)
	  public void verifyGendercolumn() throws Exception {
		  testLogs().info("verify Gender column with Username on UserPage");
		  logger = extent.createTest("To verify Gender column with Username  On UserPage");
		  Assert.assertTrue(up.verifyFemale_Male_WithUsername());
	  }
	 
	  @Test(priority=14)
	  public void verifyStateColumnWithUsername() {
		  try {
			  testLogs().info("verify MaharastraState  with Username on UserPage");
			  logger = extent.createTest("To verify MaharastraState with Username On UserPage");
			  Assert.assertTrue(up.verifyMaharashtraWithUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	  
	  @Test(priority=15)
	  public void verifyCoursesColumnWithUsername() {
		  try {
			  testLogs().info("verify Courses with Username on UserPage");
			  logger = extent.createTest("To verify Courses with Username On UserPage");
			  Assert.assertTrue(up.verifyCoursesWithIndivisualUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }

}
