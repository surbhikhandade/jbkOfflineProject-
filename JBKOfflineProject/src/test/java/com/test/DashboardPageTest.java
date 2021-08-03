package com.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashboardPage;

import jxl.read.biff.BiffException;



public class DashboardPageTest extends TestBase {
	
	public WebDriver driver = null;
	
	public DashboardPage dp = null;
	
	@BeforeMethod
	public void Setup() throws Throwable {
		
		driver= OpenBrower();
		dp=loadLoginPage().navigateToDashboardPage(driver);
		dp= new DashboardPage(driver);
	
	}
	
	 @Test(priority = 1)
		public void verify_DashboardLogo() {
		  Assert.assertTrue(dp.verifyLogo());
	  }
	 
	 @Test(priority = 2)
		public void verify_SideMenu() {
		  try {
			Assert.assertTrue(dp.verifySideMenu());
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	 
	 @Test(priority = 3)
		public void verify_CoursesWithExcel() {
		  try {
			Assert.assertTrue(dp.verifyCourses_Excel());
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	 
	 @Test(priority = 4)
		public void verify_SubCoursesWithExcel() throws BiffException, IOException {
		  try {
			Assert.assertTrue(dp.verifySubCourse());
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	  }
	 
	 @Test(priority = 5)
		public void verify_Footer_Text() {
		  Assert.assertEquals(dp.VerifyFooterText(), "Design for Selenium Automation Test");;
	  }
	 
	 @Test(priority = 6)
	 public void verify_Footer() {
		  Assert.assertTrue(dp.verifyFooter());
	  }
	 
	 @Test(priority = 7)
	 public void verify_HeaderText() {
		  Assert.assertTrue(dp.verifyHeader());
	  }
	 
	 @Test(priority = 8)
	 public void verify_LogoutBtn() {
		  Assert.assertTrue(dp.verifyLogout_Button());
	  }
	
}
