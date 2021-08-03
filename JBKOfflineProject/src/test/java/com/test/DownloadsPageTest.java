package com.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.DownloadsPage;

import jxl.read.biff.BiffException;

public class DownloadsPageTest extends TestBase{
	
	public WebDriver driver = null;
	public DownloadsPage dop = null;
	
	@BeforeMethod
	public void Setup() throws Throwable{
		driver=OpenBrower();
		dop = loadLoginPage().navigateToDashboardPage(driver).navigatetToDownloadsPage(driver);
	}
	/*
	 @Test(priority=1)
	  public void verifyHeaderOfDownloadsPage() {
		  testLogs().info("verify Header of DownLoadsPage");
		  logger = extent.createTest("To verify Header of DownLoadsPage");
		  try {
			Assert.assertTrue(dop.verifyHeaderOf_DownloadsPage());
		} catch (Exception e) {						
			e.printStackTrace();
		}
	  }
	 */
	 @Test(priority=2)
	  public void verifyVender_OfGoogleChrome_WithVersion() {
		  testLogs().info("verify Vender of Goolechrome with version");
		  logger = extent.createTest("To Vender of Goolechrome with version");
		  try {
			Assert.assertTrue(dop.verifyVendorOfGoogleChrome_withVersion());
		} catch (Exception e) {						
			e.printStackTrace();
		}
	  }
	 
	 @Test(priority=3)
	  public void verifyVendorOfSeleniumJarWithVersion() {
		  testLogs().info("verify Vender of Selenium Jar with version");
		  logger = extent.createTest("To verify Vender of Selenium Jar with version");
		  try {
			Assert.assertTrue(dop.verify_VendorOfSeleniumjar_withVersion());
		} catch (Exception e) {						
			e.printStackTrace();
		}
	  }
	 
	 @Test(priority=4)
	  public void verifyVendorAndVersionOf32bit() {
		  testLogs().info("verify Vender & Version of 32 bit");
		  logger = extent.createTest("To verify Vender & Version of 32 bit");
		  try {
			Assert.assertTrue(dop.verifyVendorAndVersionOf_32bit());
		} catch (Exception e) {						
			e.printStackTrace();
		}
	  }
	 
	 @Test(priority=5)
	  public void verifyVendorAndVersionOf64bit() {
		  testLogs().info("verify Vender & Version of 64 bit");
		  logger = extent.createTest("To verify Vender & Version of 64 bit");
		  try {
			Assert.assertTrue(dop.verifyVendorAndVersionOf_64bit());
		} catch (Exception e) {						
			e.printStackTrace();
		}
	  }
	 
	 @Test(priority=6)
	  public void verifySerialNoWithExcel() {
		  testLogs().info("verify SerialNo with Excel");
		  logger = extent.createTest("To verify SerialNo with Excel");
		  try {
			Assert.assertTrue(dop.verifySerialNo_WithExcel());
		} catch (Exception e) {						
			e.printStackTrace();
		}
	  }
	 
	 @Test(priority=7)
	  public void verifyVendorsFor32bit_64bit() {
		  testLogs().info("verify Vender of 32bit & 64bit");
		  logger = extent.createTest("To verify Vender of 32bit & 64bit");
		  try {
			Assert.assertTrue(dop.verifyVendorsFor_32bitAnd64bit());
		} catch (Exception e) {						
			e.printStackTrace();
		}
	  }
	 
	 @Test(priority=8)
	  public void verifyCommon_vendors() {
		  testLogs().info("verify Common Vender on downloads Page");
		  logger = extent.createTest("To verify Common Vender on downloads Page");
		  try {
			Assert.assertTrue(dop.verifyCommonVendors());
		} catch (Exception e) {						
			e.printStackTrace();
		}
	  }
	 
}
